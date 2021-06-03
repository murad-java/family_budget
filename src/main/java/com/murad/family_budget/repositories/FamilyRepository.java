package com.murad.family_budget.repositories;

import com.murad.family_budget.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Murad Salmanov (legenda)
 * @created 03/06/2021 - 4:24
 * @project family_budget
 */
public interface FamilyRepository extends JpaRepository<Family,Long> {

}
