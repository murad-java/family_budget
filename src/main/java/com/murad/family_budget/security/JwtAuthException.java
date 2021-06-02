package com.murad.family_budget.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

/**
 * @author Murad Salmanov (legenda)
 * @created 02/06/2021 - 1:16
 * @project family_budget
 */
@Getter
public class JwtAuthException extends AuthenticationException {
    HttpStatus httpStatus;
    public JwtAuthException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAuthException(String msg) {
        super(msg);
    }


    public JwtAuthException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}
