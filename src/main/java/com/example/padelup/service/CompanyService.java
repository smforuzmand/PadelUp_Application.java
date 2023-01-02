package com.example.padelup.service;

import com.example.padelup.entity.Company;
import io.vavr.Tuple2;

import java.util.List;

public interface CompanyService {
   Company create (final Company company);

   void delete(final Integer id);
   Company update(final Integer id, final Company company);
   Company findById(final Integer id);
   List<Company> findAll();

   Tuple2<Company, Double> getPoints(final Integer id);

   List<Tuple2<Company, Double>> getAllCompaniesScores();
}
