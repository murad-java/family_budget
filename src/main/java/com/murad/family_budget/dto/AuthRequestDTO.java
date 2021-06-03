package com.murad.family_budget.dto;

import lombok.Data;

/**
 * @author Murad Salmanov (legenda)
 * @created 02/06/2021 - 0:36
 * @project family_budget
 */
@Data
public class AuthRequestDTO {
    private String email;
    private String password;
}
