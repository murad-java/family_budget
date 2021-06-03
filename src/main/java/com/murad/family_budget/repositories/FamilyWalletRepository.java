package com.murad.family_budget.repositories;

import com.murad.family_budget.entity.FamilyWallet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Murad Salmanov (legenda)
 * @created 03/06/2021 - 3:01
 * @project family_budget
 */
public interface FamilyWalletRepository extends JpaRepository<FamilyWallet,Long> {
}
