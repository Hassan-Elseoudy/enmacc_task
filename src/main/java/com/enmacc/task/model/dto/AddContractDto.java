package com.enmacc.task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddContractDto {

    @Range(min = 0)
    private Long fromCompany;

    @Range(min = 0)
    private Long toCompany;

}
