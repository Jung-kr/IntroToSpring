package com.jung.spring.controller;

import com.jung.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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


}
