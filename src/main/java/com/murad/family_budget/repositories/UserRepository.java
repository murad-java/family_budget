package com.murad.family_budget.repositories;

import com.murad.family_budget.entity.User;
import org.hibernate.mapping.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Murad Salmanov (legenda)
 * @created 01/06/2021 - 20:51
 * @project family_budget
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    User findFirstByEmail(String email);
    User findFirstById(long id);
    List<User> findByFamilyIdOrderByRole(long familyId);
}
