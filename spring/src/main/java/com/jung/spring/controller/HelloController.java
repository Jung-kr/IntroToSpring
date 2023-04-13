package com.jung.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // MVC 패턴과 템플릿 엔진(Thymeleaf) 이용하여 hello-template.html 반환
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 방식으로 문자 보내기
    @GetMapping("hello-string")
    @ResponseBody   // http 응답시 body 부에 데이터를 직접 넣어주겠다는 어노테이션
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // API 방식으로 데이터 보내기 (객체 리턴하면 json 반환이 default)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPI(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // 데이터를 저장하기 위한 객체 생성
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
