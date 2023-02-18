package com.example.padelup.service;

import com.example.padelup.entity.Company;
import com.example.padelup.entity.Player;
import com.example.padelup.entity.Round;
import com.example.padelup.exception.EntityNotFoundException;
import com.example.padelup.repo.CompanyRepo;
import io.vavr.Tuple2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CompanyServiceImplTest {

    private CompanyServiceImpl companyService;

    @Mock
    private CompanyRepo companyRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        companyService = new CompanyServiceImpl(companyRepo);
    }

    @Test
    void testCreateCompany() {
        Company company = new Company();
        company.setCompanyName("Test Company");
        when(companyRepo.save(any(Company.class))).thenReturn(company);
        Company savedCompany = companyService.create(company);
        assertNotNull(savedCompany.getId());
        assertEquals("Test Company", savedCompany.getCompanyName());
    }

    @Test
    void testDeleteCompany() {
        int id = 1;
        doNothing().when(companyRepo).deleteById(id);
        companyService.delete(id);
        verify(companyRepo, times(1)).deleteById(id);
    }

    @Test
    void testDeleteCompanyNotFound() {
        int id = 1;
        doThrow(EntityNotFoundException.class).when(companyRepo).deleteById(id);
        assertThrows(EntityNotFoundException.class, () -> companyService.delete(id));
    }

    @Test
    void testUpdateCompany() {
        int id = 1;
        Company existingCompany = new Company();
        existingCompany.setId(id);
        existingCompany.setCompanyName("Test Company");
        when(companyRepo.findById(id)).thenReturn(Optional.of(existingCompany));
        Company updatedCompany = new Company();
        updatedCompany.setCompanyName("Updated Test Company");
        when(companyRepo.save(any(Company.class))).thenReturn(updatedCompany);
        Company result = companyService.update(id, updatedCompany);
        assertEquals("Updated Test Company", result.getCompanyName());
    }

    @Test
    void testUpdateCompanyNotFound() {
        int id = 1;
        Company updatedCompany = new Company();
        updatedCompany.setId(id);
        updatedCompany.setCompanyName("Updated Test Company");
        when(companyRepo.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> companyService.update(id, updatedCompany));
    }

    @Test
    void testFindCompanyById() {
        int id = 1;
        Company company = new Company();
        company.setId(id);
        when(companyRepo.findById(id)).thenReturn(Optional.of(company));
        Company result = companyService.findById(id);
        assertEquals(id, result.getId());
    }

    @Test
    void testFindCompanyByIdNotFound() {
        int id = 1;
        when(companyRepo.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> companyService.findById(id));
    }

}