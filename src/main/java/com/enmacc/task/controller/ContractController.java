package com.enmacc.task.controller;

import com.enmacc.task.model.Contract;
import com.enmacc.task.model.dto.AddContractDto;
import com.enmacc.task.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ContractController {

    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    /**
     * Persists the given contract in the database.
     *
     * @param contract The contract to persist
     * @return The persisted contract
     */
    @PostMapping(path = "/contracts")
    public ResponseEntity<Contract> addContract(@RequestBody AddContractDto contract) {
        return ResponseEntity.created(URI.create(contractService.createOne(contract).getId().toString())).build();
    }

    /**
     * Computes based on the contracts in the database all sleeves for the two given companies.
     *
     * @param aCompany A company
     * @param bCompany B company
     * @return The list of sleeves. A sleeve is a list of contracts between the companies.
     */
    @GetMapping(path = "/sleeves")
    public ResponseEntity<List<String>> getAllPossibleSleeves(Long aCompany, Long bCompany) {

        // TODO implement

        throw new IllegalStateException("implementation missing");
    }

}
