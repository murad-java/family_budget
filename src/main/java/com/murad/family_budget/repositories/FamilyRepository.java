package com.murad.family_budget.repositories;

import com.murad.family_budget.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Murad Salmanov (legenda)
 * @created 03/06/2021 - 4:24
 * @project family_budget
 */
public interface FamilyRepository extends JpaRepository<Family,Long> {

    @Modifying
    @Query("update User u set u.priceLimit = :limit")
    void setLimitAllFamilies(@Param("limit") float limit);

    @Modifying
    @Query("update User u set u.priceLimit = :limit where u.familyId = :fId")
    void setLimitMyAllMembers(@Param("fId") long fId,@Param("limit") float limit);

    @Modifying
    @Query("update User u set u.priceLimit = :limit where u.id = :userId")
    void setLimitMember(@Param("userId") long userId,@Param("limit") float limit);
}
