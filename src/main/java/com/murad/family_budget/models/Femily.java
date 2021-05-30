package com.murad.family_budget.models;

import lombok.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Murad Salmanov (legenda)
 * @created 30/05/2021 - 3:30
 * @project FamilyBudget
 */
@Controller
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Femily {
    private long id;
    private String name;

    @Override
    public String toString() {
        return "Femily{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
