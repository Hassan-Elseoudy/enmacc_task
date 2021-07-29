package com.enmacc.task.controller;

import com.enmacc.task.model.Contract;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.enmacc.task.model.dto.AddContractDto;
import java.util.List;

@RestController
public class ContractController {

    /**
     * Persists the given contract in the database.
     *
     * @param contract The contract to persist
     * @return The persisted contract
     */
    @PostMapping(path = "/contracts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Contract> addContract(AddContractDto contract) {

        // TODO implement

        throw new IllegalStateException("implementation missing");
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
