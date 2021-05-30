package com.murad.family_budget.controllers;

import com.murad.family_budget.models.Femily;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Murad Salmanov (legenda)
 * @created 30/05/2021 - 3:28
 * @project FamilyBudget
 */
@RestController
public class FemilyControllers {
    @Autowired
    ObjectFactory<Femily> femily = null;

    @GetMapping("/families")
    public Set<Femily> getFamilies() {

        Set<Femily> femilies = new HashSet<Femily>();
        femilies.add(femily.getObject().builder().name("family1").id(1234).build());
        femilies.add(femily.getObject().builder().name("family2").id(1434).build());
        femilies.add(femily.getObject().builder().name("family3").id(5234).build());
        femilies.add(femily.getObject().builder().name("family4").id(1734).build());
        femilies.add(femily.getObject().builder().name("family5").id(8234).build());
        return femilies;
    }
}
