package com.enmacc.task.controller;

import com.enmacc.task.model.dto.AddCompanyDto;
import com.enmacc.task.model.dto.CompanyResponseDtoV1;
import com.enmacc.task.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<CompanyResponseDtoV1> createCompany(@Valid @RequestBody AddCompanyDto companyDto) {
        CompanyResponseDtoV1 responseDtoV1 = CompanyResponseDtoV1.toDto(companyService.createOne(companyDto));
        return ResponseEntity
                .created(URI.create(responseDtoV1.getId().toString()))
                .body(responseDtoV1);
    }

    /**
     * Get a specific company's information.
     *
     * @param id The id of the company
     * @return The persisted company.
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyResponseDtoV1> getCompany(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(CompanyResponseDtoV1.toDto(companyService.getOne(id)));
    }

}
