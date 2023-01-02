package com.example.padelup.controller;

import com.example.padelup.controller.beans.ResultResp;
import com.example.padelup.controller.beans.ScoreResp;
import com.example.padelup.entity.Company;
import com.example.padelup.service.CompanyService;
import io.vavr.Tuple2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody final Company company) {
        final Company companyCreated = companyService.create(company);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(companyCreated);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Company> update(@PathVariable("id") final Integer cId,
                                          @RequestBody final Company company) {
        final Company updatedCompany = companyService.update(cId, company);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(updatedCompany);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResultResp> deleteCompany(@PathVariable("id") final Integer cId) {
        companyService.delete(cId);
        return ResponseEntity.ok(new ResultResp("Company deleted!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(companyService.findById(id));
    }

    @GetMapping("/{id}/score")
    public ResponseEntity<ScoreResp> getScore(@PathVariable("id") final Integer id) {
        final Tuple2<Company, Double> result = companyService.getPoints(id);
        return ResponseEntity.ok(new ScoreResp(result._1().getCompanyName(), result._2()));
    }

    @GetMapping("/score")
    public ResponseEntity<List<ScoreResp>> getScores() {
        final List<Tuple2<Company, Double>> results = companyService.getAllCompaniesScores();
        final List<ScoreResp> response = results.stream()
                .map(result -> new ScoreResp(result._1().getCompanyName(), result._2()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(companyService.findAll());
    }


}
