package com.jung.spring;

import com.jung.spring.repository.*;
import com.jung.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
        this.dataSource = dataSource;
        this.em = em;
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

/*    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);    // 순수 Jdbc를 이용한 데이터 엑세스
        //return new JdbcTemplateMemberRepository(dataSource);    // JdbcTemplate을 이용한 데이터 엑세스
        //return new JpaMemberRepository(em); // JPA를 이용한 데이터 엑세스
    }

*/
}
