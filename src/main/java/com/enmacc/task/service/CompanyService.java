package com.enmacc.task.service;

import com.enmacc.task.model.Company;
import com.enmacc.task.model.dto.AddCompanyDto;

import java.util.List;

public interface CompanyService {

    /**
     * get company by Id
     *
     * @param id company id
     * @return Company
     */
    Company getOne(Long id);

    /**
     * create company
     *
     * @param companyDto company id
     * @return Company
     */
    Company createOne(AddCompanyDto companyDto);

    /**
     * get all companies
     * @return list of all companies.
     */
    List<Company> findAll();


    /**
     * get number of companies in db.
     * @return number of rows.
     */
    Long getNumberOfCompanies();


}
