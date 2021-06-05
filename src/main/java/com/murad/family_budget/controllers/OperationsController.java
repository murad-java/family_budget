package com.murad.family_budget.controllers;

import com.murad.family_budget.models.Operation;
import com.murad.family_budget.models.Score;
import com.murad.family_budget.security.JwtTokenProvider;
import com.murad.family_budget.services.OperationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Murad Salmanov (legenda)
 * @created 04/06/2021 - 7:15
 * @project family_budget
 */
@RestController
public class OperationsController {
    private final JwtTokenProvider jwtTokenProvider;
    private final OperationService operationService;

    public OperationsController(JwtTokenProvider jwtTokenProvider, OperationService operationService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.operationService = operationService;
    }


    @GetMapping("/my/operation")
    @PreAuthorize("hasAuthority('family:get_operations')")
    public List<Operation> getMyOperations(HttpServletRequest request) {
        String myEmail = jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(request));
        return operationService.getMyTransaction(myEmail);
    }

    @PostMapping("/money/in")
    @PreAuthorize("hasAuthority('family:in_money')")
    public String inMoney(@RequestBody Score score, HttpServletRequest request) {
        try {
            String myEmail = jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(request));
            System.out.println(score);
            operationService.inMoney(myEmail, new BigDecimal(score.getScore().trim()));
        } catch (Exception e) {
            System.out.println(e.toString());
            return "failed operation";
        }
        return "successful operation";
    }

    @PostMapping("/money/out")
    @PreAuthorize("hasAuthority('family:out_money')")
    public String outMoney(@RequestBody Score score, HttpServletRequest request) {
        String response = "";
        try {
            String myEmail = jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(request));
            System.out.println(score);
            response = operationService.outMoney(myEmail, new BigDecimal( score.getScore().trim()));
        } catch (Exception e) {
            System.out.println(e.toString());
            return "failed operation";
        }
        return response;
    }
}
