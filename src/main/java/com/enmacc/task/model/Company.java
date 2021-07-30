package com.enmacc.task.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy="firstEnd")
    private List<Contract> outgoingContracts;

    @OneToMany(mappedBy="secondEnd")
    private List<Contract> ingoingContracts;

}
