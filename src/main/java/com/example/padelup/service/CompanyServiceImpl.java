package com.example.padelup.service;

import com.example.padelup.model.dto.CompanyDto;
import com.example.padelup.model.entity.Company;
import com.example.padelup.model.form.CompanyForm;
import com.example.padelup.repo.CompanyRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

   private  final CompanyRepo companyRepo;
   private final ModelMapper modelMapper;

   @Autowired
   public CompanyServiceImpl(CompanyRepo companyRepo, ModelMapper modelMapper){
      this.modelMapper = modelMapper;
      this.companyRepo = companyRepo;
   }

   @Override
   @Transactional
   public CompanyDto create(CompanyForm form) {
      Company company = modelMapper.map(form,Company.class);
      Company savedCompany = companyRepo.save(company);
      return modelMapper.map(savedCompany,CompanyDto.class);
   }

   @Override
   @Transactional
   public boolean delete(Integer id) {
      return false;
   }

   @Override
   @Transactional
   public CompanyDto update(Integer id, CompanyForm updateForm) {
      return null;
   }

   @Override
//   @Transactional(readOnly = true)
   public CompanyDto findById(Integer companyId) {
         Optional<Company> foundCompany = companyRepo.findById(companyId);
         Company company = foundCompany.orElseThrow(()
                 -> new IllegalArgumentException ("Could not find Company by Id " + companyId));
         return modelMapper.map(foundCompany, CompanyDto.class);
      }


   @Override
   @Transactional(readOnly = true)
   public List<CompanyDto> findAll() {
//         Iterable<Company> foundCompany = companyRepo.findAll();
//         List<CompanyDto> companyDtoList = new ArrayList<>();
//         foundCompany.forEach( (company) -> companyDtoList.add(modelMapper.map()) );
         return null;

   }
}
