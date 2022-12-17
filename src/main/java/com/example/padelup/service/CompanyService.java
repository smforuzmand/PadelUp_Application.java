package com.example.padelup.service;

import com.example.padelup.model.dto.CompanyDto;
import com.example.padelup.model.form.CompanyForm;

import java.util.List;

public interface CompanyService {
   CompanyDto create (CompanyForm form);

   boolean delete(Integer id);
   CompanyDto update(Integer id, CompanyForm updateForm);
   CompanyDto findById(Integer id);
   List<CompanyDto> findAll();

}
