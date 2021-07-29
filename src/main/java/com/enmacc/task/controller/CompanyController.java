package com.enmacc.task.controller;

import com.enmacc.task.model.Company;
import com.enmacc.task.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.enmacc.task.model.dto.AddCompanyDto;

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
    @PostMapping(path = "/contracts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Company> createCompany(AddCompanyDto companyDto) {
        return ResponseEntity.ok(companyService.createOne(companyDto));
    }

    /**
     * Get a specific company's information.
     *
     * @param id The id of the company
     * @return The persisted company.
     */
    @PostMapping(path = "/contracts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Company> getCompany(Long id) {
        return ResponseEntity.ok(companyService.getOne(id));
    }

}
