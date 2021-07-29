package com.enmacc.task.service;

import com.enmacc.task.model.Contract;
import com.enmacc.task.model.dto.AddContractDto;
import com.enmacc.task.repository.ContractRepository;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final CompanyService companyService;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, CompanyService companyService) {
        this.contractRepository = contractRepository;
        this.companyService = companyService;
    }

    /**
     * get contract by Id
     *
     * @param id contract id
     * @return Contract
     */
    @Override
    public Contract getOne(Long id) {
        return contractRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * create contract using bi-directional role.
     *
     * @param contractDto
     * @return Contract
     */
    @Override
    public Contract createOne(AddContractDto contractDto) {
        Contract fromContract = new Contract();
        fromContract.setFrom(companyService.getOne(contractDto.getFromCompany()));
        fromContract.setTo(companyService.getOne(contractDto.getToCompany()));

        Contract toContract = new Contract();
        toContract.setFrom(companyService.getOne(contractDto.getFromCompany()));
        toContract.setTo(companyService.getOne(contractDto.getToCompany()));


        return contractRepository.saveAll(List.of(fromContract, toContract)).get(0);
    }
}
