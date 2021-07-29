package com.enmacc.task.service;

import com.enmacc.task.model.Contract;
import com.enmacc.task.model.dto.AddContractDto;

import java.util.List;

public interface ContractService {

    /**
     * get contract by Id
     * @param id contract id
     * @return Contract
     */
    Contract getOne(Long id);

    /**
     * create contract
     * @param contractDto create contract dto
     * @return Contract
     */
    Contract createOne(AddContractDto contractDto);

    /**
     *
     * @return list of contracts
     */
    List<Contract> getAllContracts();

    /**
     *
     * @param source source node
     * @param destination destination node
     * @return all sleeves between 2 companies.
     */
    List<String> getAllSleeves(Long source, Long destination);

}
