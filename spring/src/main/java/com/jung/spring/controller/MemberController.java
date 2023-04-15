package com.jung.spring.controller;

import com.jung.spring.domain.Member;
import com.jung.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    // 1)생성자를 톻한 의존성 주입
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 2)필드롤 통한 의존성 주입
    /*
    @Autowired private MemberService memberService;
     */

    // 3)setter를 통한 의존성 주입
    /*
    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
     */

    // 회원가입 페이지
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // 회원가입 페이지에서 이름을 입력했을 때
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

}
