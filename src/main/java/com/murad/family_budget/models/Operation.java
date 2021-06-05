package com.murad.family_budget.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Murad Salmanov (legenda)
 * @created 04/06/2021 - 7:17
 * @project family_budget
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
@NoArgsConstructor
public class Operation {
    private BigDecimal    score;
    private LocalDateTime operationDateTime;
}
