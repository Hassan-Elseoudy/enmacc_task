package com.enmacc.task.model.dto;

import com.enmacc.task.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponseDtoV1 {

    private Long id;
    private String name;

    public static CompanyResponseDtoV1 toDto(Company company) {
        return new CompanyResponseDtoV1(company.getId(), company.getName());
    }
}
