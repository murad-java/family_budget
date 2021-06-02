package com.murad.family_budget.repositories;

import com.murad.family_budget.entity.User;
import org.hibernate.mapping.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Murad Salmanov (legenda)
 * @created 01/06/2021 - 20:51
 * @project family_budget
 */
public interface UserRepositories extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
