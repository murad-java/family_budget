package com.murad.family_budget.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Murad Salmanov (legenda)
 * @created 05/06/2021 - 17:21
 * @project family_budget
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitRequest {
    private long userId;
    private float limit;
}
