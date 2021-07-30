package com.enmacc.task.controller;

import com.enmacc.task.model.dto.AddContractDto;
import com.enmacc.task.model.dto.ContractResponseDtoV1;
import com.enmacc.task.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    //TODO: Maybe I should add Swagger Example of how you can create company.
    public ResponseEntity<ContractResponseDtoV1> addContract(@Valid @RequestBody AddContractDto contract) {
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
    public ResponseEntity<Set<String>> getAllPossibleSleeves(@RequestParam(name = "aCompany") Long aCompany, @RequestParam(name = "bCompany") Long bCompany) {
        return ResponseEntity.ok(new HashSet<>(contractService.getAllSleeves(aCompany, bCompany)));
    }

    /**
     * Computes all contracts stored in the database (Not Paginated yet).
     *
     * @return The list of contracts.
     */
    @GetMapping(path = "/contracts")
    public ResponseEntity<List<ContractResponseDtoV1>> getAllContracts() {
        return ResponseEntity.ok((contractService.getAllContracts().stream().map(ContractResponseDtoV1::toDto)).collect(Collectors.toList()));
    }

}
