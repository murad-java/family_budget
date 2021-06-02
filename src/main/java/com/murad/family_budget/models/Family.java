package com.murad.family_budget.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Murad Salmanov (legenda)
 * @created 30/05/2021 - 3:30
 * @project FamilyBudget
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Family {
    private long   id;
    private String name;

    @Override
    public String toString() {
        return "Femily{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
