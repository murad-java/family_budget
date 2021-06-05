package com.murad.family_budget.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Murad Salmanov (legenda)
 * @created 03/06/2021 - 2:50
 * @project family_budget
 */
@Entity
@Data
public class FamilyWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long          id;

    private long          familyId;
    private long          userId;
    @Column(nullable = false)
    private BigDecimal    score;
    @Column(nullable = false)
    private LocalDateTime operationDateTime;

    public FamilyWallet(long familyId, long userId, BigDecimal score) {
        this.familyId = familyId;
        this.userId = userId;
        this.score = score;
        this.operationDateTime =LocalDateTime.now();
    }

    public FamilyWallet() {
        this.operationDateTime =LocalDateTime.now();
    }
}
