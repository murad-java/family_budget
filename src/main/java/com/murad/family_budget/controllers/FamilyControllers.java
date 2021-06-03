package com.murad.family_budget.controllers;

import com.murad.family_budget.entity.Family;
import com.murad.family_budget.repositories.FamilyRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Murad Salmanov (legenda)
 * @created 30/05/2021 - 3:28
 * @project FamilyBudget
 */
@RestController
public class FamilyControllers {


    private final FamilyRepository familyRepository;

    public FamilyControllers(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @GetMapping("/families")
    @PreAuthorize("hasAuthority('family:read')")
    public List<Family> getFamilies() {

        List<Family> femilies = familyRepository.findAll();

        return femilies;
    }
}
