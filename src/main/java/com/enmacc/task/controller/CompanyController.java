package com.enmacc.task.controller;

import com.enmacc.task.model.Company;
import com.enmacc.task.model.dto.AddCompanyDto;
import com.enmacc.task.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * Persists the given company in the database.
     *
     * @param companyDto The company to persist
     * @return The persisted company
     */
    @PostMapping
    public ResponseEntity<Company> createCompany(AddCompanyDto companyDto) {
        return ResponseEntity.created(URI.create(companyService.createOne(companyDto).getId().toString())).build();
    }

    /**
     * Get a specific company's information.
     *
     * @param id The id of the company
     * @return The persisted company.
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(companyService.getOne(id));
    }

}
