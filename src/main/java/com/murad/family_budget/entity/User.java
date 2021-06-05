package com.murad.family_budget.entity;

import com.murad.family_budget.models.Role;
import com.murad.family_budget.models.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Murad Salmanov (legenda)
 * @created 01/06/2021 - 1:23
 * @project family_budget
 */
@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long               id;
    private long               familyId;
    private String             fullName;
    @Column(unique = true)
    private String             email;
    private String             password;
    private float              priceLimit;
    @Enumerated(value = EnumType.STRING)
    private Role               role;
    @Enumerated(value = EnumType.STRING)
    private Status             active;
    private LocalDate          birthday;
    private LocalDateTime      creteDate;

    public User(long familyId, String fullName, float priceLimit, Role role, LocalDate birthday) {
        this.familyId = familyId;
        this.fullName = fullName;
        this.priceLimit = priceLimit;
        this.role = role;
        this.birthday = birthday;
        this.creteDate = LocalDateTime.now();
    }

}
