package com.enmacc.task.service;

import com.enmacc.task.model.Company;
import com.enmacc.task.model.dto.AddCompanyDto;

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

}
