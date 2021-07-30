package com.enmacc.task.model.dto;

import com.enmacc.task.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCompanyDto {

    @NotEmpty
    private String name;

    public static Company toModel(AddCompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        return company;
    }
}
