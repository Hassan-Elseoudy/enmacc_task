package com.enmacc.task.service;

import com.enmacc.task.model.Company;
import com.enmacc.task.model.dto.AddCompanyDto;
import com.enmacc.task.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * get contract by Id
     *
     * @param id contract id
     * @return Contract
     */
    @Override
    //TODO: That's not the best way of getting entity from the database, error handling to return 404 should be a solution.
    public Company getOne(Long id) {
        return companyRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * create company
     *
     * @param companyDto
     * @return Contract
     */
    @Override
    public Company createOne(AddCompanyDto companyDto) {
        return companyRepository.save(AddCompanyDto.toModel(companyDto));
    }
}
