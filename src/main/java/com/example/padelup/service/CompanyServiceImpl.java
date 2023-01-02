package com.example.padelup.service;

import com.example.padelup.entity.Company;
import com.example.padelup.entity.Player;
import com.example.padelup.entity.Round;
import com.example.padelup.exception.EntityNotFoundException;
import com.example.padelup.repo.CompanyRepo;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;
    public CompanyServiceImpl(final CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    @Transactional
    public Company create(final Company company) {
        return companyRepo.save(company);
    }

    @Override
    @Transactional
    public void delete(final Integer id) {
        Try.run(() -> companyRepo.deleteById(id))
                .getOrElseThrow(() -> new EntityNotFoundException(Company.class, "id", id.toString()));
    }

    @Override
    @Transactional
    public Company update(final Integer id, final Company company) {
        return companyRepo.findById(id)
                .map(dbCompany -> {
                    dbCompany.setCompanyName(company.getCompanyName());
                    return companyRepo.save(dbCompany);
                }).orElseThrow(() -> new EntityNotFoundException(Company.class, "id", String.valueOf(company.getId())));
    }

    @Override
    @Transactional(readOnly = true)
    public Company findById(final Integer companyId) {
        return companyRepo.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException(Company.class, "id", companyId.toString()));
    }


    @Override
    @Transactional(readOnly = true)
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public Tuple2<Company, Double> getPoints(final Integer id) {

        final Company company = companyRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Company.class, "id", id.toString()));

        final Double score = calculatePoints(company.getPlayerList());

        return Tuple.of(company, score);
    }

    @Override
    public List<Tuple2<Company, Double>> getAllCompaniesScores() {
        return companyRepo.findAll().stream()
                .map(company -> getPoints(company.getId()))
                .collect(Collectors.toList());
    }

    private Double calculatePoints(Set<Player> players) {
        return players.stream()
                .filter(it -> !it.getRounds().isEmpty())
                .map(this::getAverageForOnePlayer)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    private Double getAverageForOnePlayer(Player player) {
        return player.getRounds().stream()
                .map(Round::getPoints)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }
}
