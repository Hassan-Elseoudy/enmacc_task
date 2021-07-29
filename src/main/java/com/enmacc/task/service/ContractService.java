package com.enmacc.task.service;

import com.enmacc.task.model.Contract;
import com.enmacc.task.model.dto.AddContractDto;

public interface ContractService {

    /**
     * get contract by Id
     * @param id contract id
     * @return Contract
     */
    Contract getOne(Long id);

    /**
     * create contract
     * @param id contract id
     * @return Contract
     */
    Contract createOne(AddContractDto contractDto);

}
