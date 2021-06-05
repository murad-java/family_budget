package com.murad.family_budget.repositories;

import com.murad.family_budget.entity.FamilyWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Murad Salmanov (legenda)
 * @created 03/06/2021 - 3:01
 * @project family_budget
 */
public interface FamilyWalletRepository extends JpaRepository<FamilyWallet, Long> {
     List<FamilyWallet> findByUserIdOrderByFamilyId(long id);
     @Query(value="select sum (score) from FamilyWallet where familyId= :fId and userId=:uId and score<0 and operationDateTime>=:sDate and operationDateTime<=:eDate ")
     BigDecimal getSumOutMoney(@Param("fId") long fId,
                               @Param("uId") long userId,
                               @Param("sDate") LocalDateTime startDate,
                               @Param("eDate")LocalDateTime endDate);
     @Query(value="select sum (score) from FamilyWallet where familyId= :fId")
     BigDecimal getFamilyBalance(@Param("fId") long familyId);
}
