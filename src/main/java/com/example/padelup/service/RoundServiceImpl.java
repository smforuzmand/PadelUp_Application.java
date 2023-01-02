package com.example.padelup.service;

import com.example.padelup.entity.Round;
import com.example.padelup.exception.EntityNotFoundException;
import com.example.padelup.repo.RoundRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoundServiceImpl implements  RoundService{
   private final RoundRepo roundRepo;

   public RoundServiceImpl(final RoundRepo roundRepo){
      this.roundRepo = roundRepo;
   }
   @Override
   @Transactional
   public Round create(final Round round) {
      return roundRepo.save(round);
   }

   @Override
   @Transactional
   public void delete(final Integer id) {
      roundRepo.deleteById(id);
   }

   @Override
   @Transactional
   public Round update(final Integer id, final Round round) {
      return roundRepo.findById(id)
              .map(dbRound -> {
                 dbRound.setPoints(round.getPoints());
                 return roundRepo.save(dbRound);
              })
              .orElseThrow(() -> new EntityNotFoundException(Round.class, "id", String.valueOf(round.getRoundId())));
   }

   @Override
   @Transactional(readOnly = true)
   public Round findById(Integer roundId) {
      return roundRepo.findById(roundId)
              .orElseThrow(() -> new EntityNotFoundException(Round.class, "id", roundId.toString()));
   }

   @Override
   @Transactional(readOnly = true)
   public List<Round> findAll() {
      return roundRepo.findAll();
   }
}
