package com.murad.family_budget.services;

import com.murad.family_budget.entity.User;
import com.murad.family_budget.models.Role;
import com.murad.family_budget.repositories.FamilyRepository;
import com.murad.family_budget.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Murad Salmanov (legenda)
 * @created 05/06/2021 - 8:39
 * @project family_budget
 */
@Service
@Transactional
public class FamilyService {
    private final FamilyRepository familyRepository;
    private final UserRepository   userRepository;

    public FamilyService(FamilyRepository familyRepository, UserRepository userRepository) {
        this.familyRepository = familyRepository;
        this.userRepository = userRepository;
    }

    public void setLimitsAllFamilies(float limit) throws Exception {
        familyRepository.setLimitAllFamilies(limit);
    }

    public void setLimitMyAllMembers(String email, float limit) throws Exception {
        User user = getUser(email);
        familyRepository.setLimitMyAllMembers(user.getFamilyId(), limit);
    }

    private User getUser(String email) {
        User user = userRepository.findFirstByEmail(email);
        return user;
    }

    private User getUser(long userId) {
        User user = userRepository.findFirstById(userId);
        return user;
    }

    public String setLimitFamilyMember(String email, long userId, float limit) throws Exception {
        User myUser = getUser(email);
        User member = getUser(userId);
        if(myUser.getRole().equals(Role.SUPER_ADMINISTRATOR)){
            familyRepository.setLimitMember( userId, limit);
            return "successfully";
        }else if(myUser.getRole().equals(Role.ADMINISTRATOR)){
            if (myUser.getFamilyId()==member.getFamilyId()){
                familyRepository.setLimitMember( userId, limit);
                return "successfully";
            }else{
                return "You don't have access";
            }
        }
        return "successfully";
    }
}
