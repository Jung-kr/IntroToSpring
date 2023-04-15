package com.jung.spring;

import com.jung.spring.repository.JdbcMemberRepository;
import com.jung.spring.repository.JdbcTemplateMemberRepository;
import com.jung.spring.repository.MemberRepository;
import com.jung.spring.repository.MemoryMemberRepository;
import com.jung.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);    // 순수 Jdbc를 이용한 데이터 엑세스
        return new JdbcTemplateMemberRepository(dataSource);    // JdbcTemplate을 이용한 데이터 엑세스
    }
}
