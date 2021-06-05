package com.murad.family_budget.controllers;

import com.murad.family_budget.entity.Family;
import com.murad.family_budget.models.LimitRequest;
import com.murad.family_budget.models.Member;
import com.murad.family_budget.repositories.FamilyRepository;
import com.murad.family_budget.security.JwtTokenProvider;
import com.murad.family_budget.services.FamilyService;
import com.murad.family_budget.services.MemberService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Murad Salmanov (legenda)
 * @created 30/05/2021 - 3:28
 * @project FamilyBudget
 */
@RestController
public class FamilyController {


    private final FamilyRepository familyRepository;
    private final MemberService    memberService;
    private final JwtTokenProvider jwtTokenProvider;
    private final FamilyService    familyService;

    public FamilyController(FamilyRepository familyRepository, MemberService memberService, JwtTokenProvider jwtTokenProvider, FamilyService familyService) {
        this.familyRepository = familyRepository;
        this.memberService = memberService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.familyService = familyService;
    }

    @GetMapping("/families")
    @PreAuthorize("hasAuthority('families:get_all_families')")
    public List<Family> getFamilies() {

        List<Family> femilies = familyRepository.findAll();

        return femilies;
    }

    @GetMapping("/my/family/members")
    @PreAuthorize("hasAuthority('family:get_my_members')")
    public List<Member> getMembers(HttpServletRequest request) {
        List<Member> members = memberService.getMembers(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(request)));
        return members;
    }

    @GetMapping("/family/members/{id}")
    @PreAuthorize("hasAuthority('families:get_any_members')")
    public List<Member> getMembersById(@PathVariable(value = "id", required = true) long id, HttpServletRequest request) {
        List<Member> members = memberService.getMembers(id);
        return members;
    }

    @PostMapping("/families/limits")
    @PreAuthorize("hasAuthority('families:limit_all_familis')")
    public String setLimitAllFamilies(@RequestBody LimitRequest limit) {
        try {
            familyService.setLimitsAllFamilies(limit.getLimit());
        } catch (Exception e) {
            System.out.println(e.toString());
            return "failure";
        }
        return "successfully";
    }

    @PostMapping("/family/limits")
    @PreAuthorize("hasAuthority('family:set_limit_member')")
    public String setLimitMyAllMembers(@RequestBody LimitRequest limit, HttpServletRequest request) {
        String email=jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(request));
        try {
            familyService.setLimitMyAllMembers(email,limit.getLimit());
        } catch (Exception e) {
            System.out.println(e.toString());
            return "failure";
        }
        return "successfully";
    }
    @PostMapping("/family/member/limit")
    @PreAuthorize("hasAuthority('family:set_limit_member')")
    public String setLimitFamilyMember(@RequestBody LimitRequest limit, HttpServletRequest request) {
        String email=jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(request));
        String respStr;
        try {
            respStr=familyService.setLimitFamilyMember(email,limit.getUserId(),limit.getLimit());
        } catch (Exception e) {
            System.out.println(e.toString());
            return "failure";
        }
        return respStr;
    }

}
