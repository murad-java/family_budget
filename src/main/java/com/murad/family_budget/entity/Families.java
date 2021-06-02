package com.murad.family_budget.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Murad Salmanov (legenda)
 * @created 01/06/2021 - 1:00
 * @project family_budget
 */
@Entity
@NoArgsConstructor
@Data
public class Families {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long          id;
    private String        name;
    private LocalDateTime createDate;

    public Families(String name) {
        this.name = name;
        this.createDate = LocalDateTime.now();
    }
}
