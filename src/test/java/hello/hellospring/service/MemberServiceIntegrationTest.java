package hello.hellospring.service;

import hello.hellospring.damain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName(value = "회원 가입")
    void join() {
        // given
        final Member member = new Member();
        member.setName("hello");

        // when
        final Long saveId = this.memberService.join(member);

        // then
        final Member findMember = this.memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    @DisplayName(value = "중복 회원 예외")
    void validateDuplicateMember() {
        // given
        final Member member1 = new Member();
        member1.setName("spring");

        final Member member2 = new Member();
        member2.setName("spring");

        // when
        this.memberService.join(member1);
        final Exception e = assertThrows(IllegalStateException.class, () -> this.memberService.join(member2));

        // then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}
