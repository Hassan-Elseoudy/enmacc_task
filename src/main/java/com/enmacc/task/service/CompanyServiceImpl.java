package com.enmacc.task.service;

import com.enmacc.task.model.Company;
import com.enmacc.task.model.dto.AddCompanyDto;
import com.enmacc.task.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
    public Company getOne(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Didn't find company with specified {id = " + id + "}"));
    }

    /**
     * create company
     *
     * @param companyDto company dto request.
     * @return Contract
     */
    @Override
    public Company createOne(AddCompanyDto companyDto) {
        return companyRepository.save(AddCompanyDto.toModel(companyDto));
    }

    /**
     * get all companies
     *
     * @return list of all companies.
     */
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    /**
     * get number of companies in db.
     * @return number of rows.
     */
    public Long getNumberOfCompanies(){
        return companyRepository.count();
    }
}
