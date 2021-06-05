package com.murad.family_budget.services;

import com.murad.family_budget.entity.User;
import com.murad.family_budget.models.Member;
import com.murad.family_budget.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Murad Salmanov (legenda)
 * @created 04/06/2021 - 5:01
 * @project family_budget
 */
@Service
@NoArgsConstructor
@Transactional
public class MemberService {

    private UserRepository userRepository;

    private ObjectFactory<Member> memberObjectFactory;

    @Autowired
    public MemberService(UserRepository userRepository, ObjectFactory<Member> memberObjectFactory) {
        this.userRepository = userRepository;
        this.memberObjectFactory = memberObjectFactory;
    }


    public List<Member> getMembers(String username) {
        List<User> users = userRepository.findByFamilyIdOrderByRole(getUserFamilyId(username));
        return convertUsersToMembers(users);
    }

    public List<Member> getMembers(long id) {
        List<User> users = userRepository.findByFamilyIdOrderByRole(id);
        return convertUsersToMembers(users);
    }

    private List<Member> convertUsersToMembers(List<User> users) {
        List<Member> members = new ArrayList<>();
        for (User user : users) {
            Member member = memberObjectFactory.getObject();
            member.setId(user.getId());
            member.setEmail(user.getEmail());
            member.setFullName(user.getFullName());
            member.setBirthday(user.getBirthday());
            member.setPriceLimit(user.getPriceLimit());
            members.add(member);
        }
        return members;
    }

    private long getUserFamilyId(String username) {
        System.out.println("USER NAME:" + username);
        User user = userRepository.findFirstByEmail(username);
        System.out.println(user.getRole());
        return user.getFamilyId();

    }
}
