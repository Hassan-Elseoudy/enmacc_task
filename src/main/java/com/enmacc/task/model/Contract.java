package com.enmacc.task.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn
    private Company from;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn
    private Company to;

}
