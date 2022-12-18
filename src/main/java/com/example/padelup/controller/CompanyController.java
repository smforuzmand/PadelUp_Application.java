package com.example.padelup.controller;

import com.example.padelup.model.dto.CompanyDto;
import com.example.padelup.model.entity.Company;
import com.example.padelup.model.form.CompanyForm;
import com.example.padelup.repo.CompanyRepo;
import com.example.padelup.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/company")
public class CompanyController {

   private final CompanyService companyService;
   @Autowired
   public CompanyController(CompanyService companyService){
      this.companyService = companyService;
   }

   @PostMapping
   public ResponseEntity<CompanyDto> create(@RequestBody  CompanyForm companyForm) {
      return ResponseEntity.status(HttpStatus.CREATED).body(companyService.create(companyForm));
   }
   @DeleteMapping(path = "/{id}")
   public ResponseEntity<String> deleteCompany(@PathVariable("id") Integer cId) {

      boolean delete = companyService.delete(cId);
      return ResponseEntity.ok(delete ? "Company with id " + cId + " was deleted" : "Company Not Deleted");
   }
   @GetMapping("/{id}")
   public ResponseEntity<CompanyDto> findById(@PathVariable("id") Integer id){
      return ResponseEntity.ok(companyService.findById(id));
   }

   @GetMapping
   public ResponseEntity<List<CompanyDto>> findAll(){
      return ResponseEntity.ok(companyService.findAll());
   }


}
