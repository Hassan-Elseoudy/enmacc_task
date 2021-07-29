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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy="to")
    private List<Contract> contractsTo;

    @OneToMany(mappedBy="from")
    private List<Contract> contractsFrom;

}
