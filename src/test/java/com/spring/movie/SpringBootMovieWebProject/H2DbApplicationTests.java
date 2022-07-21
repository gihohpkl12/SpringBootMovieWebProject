package com.spring.movie.SpringBootMovieWebProject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.movie.SpringBootMovieWebProject.Domain.Member;
import com.spring.movie.SpringBootMovieWebProject.Repository.MemberRepository;

@SpringBootTest
class H2DbApplicationTests {

    private final MemberRepository memberRepository;

    // 의존성 주입
    @Autowired
    public H2DbApplicationTests(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Test
    void 회원가입() {
        // 멤버 저장
        Member member = new Member();
        member.setId("skyepodium");
        member.setEmail("aaa@aaa.com");
        memberRepository.save(member);

        // 저장한 멤버 아이디로 검색
        Member findMember = memberRepository.findByIdAndEmail(member.getId(), member.getEmail());
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
        System.out.println(findMember.getId()+" "+findMember.getEmail());
    }
}