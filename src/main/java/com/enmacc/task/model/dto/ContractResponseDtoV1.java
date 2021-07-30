package com.enmacc.task.model.dto;

import com.enmacc.task.model.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractResponseDtoV1 {

    private Long id;
    private String firstEnd;
    private String secondEnd;

    public static ContractResponseDtoV1 toDto(Contract contract) {
        return new ContractResponseDtoV1(contract.getId(), contract.getFirstEnd().getName(), contract.getSecondEnd().getName());
    }

}
