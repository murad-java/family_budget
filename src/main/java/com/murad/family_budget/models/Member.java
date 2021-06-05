package com.murad.family_budget.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author Murad Salmanov (legenda)
 * @created 04/06/2021 - 4:57
 * @project family_budget
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
@NoArgsConstructor
public class Member {
    private long      id;
    private String    fullName;
    private String    email;
    private float     priceLimit;
    private LocalDate birthday;
}
