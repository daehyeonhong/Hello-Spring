package hello.hellospring.repository;

import hello.hellospring.damain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {
    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void tearDown() {
        this.memberRepository.clearStore();
    }

    @Test
    @DisplayName(value = "멤버를 저장한다.")
    void save() {
        final Member member = new Member();
        member.setName("spring");

        this.memberRepository.save(member);

        final Member result = this.memberRepository.findById(member.getId()).get();

//        System.out.println("result = " + (result == member));
        assertThat(member).isEqualTo(result);
    }

    @Test
    @DisplayName(value = "멤버 이름으로 멤버를 찾는다.")
    void findByName() {
        final Member member1 = new Member();
        member1.setName("spring1");
        this.memberRepository.save(member1);

        final Member member2 = new Member();
        member2.setName("spring2");
        this.memberRepository.save(member2);

        final Member result = this.memberRepository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    @DisplayName(value = "모든 멤버를 찾는다.")
    void findAll() {
        final Member member1 = new Member();
        member1.setName("spring1");
        this.memberRepository.save(member1);

        final Member member2 = new Member();
        member2.setName("spring2");
        this.memberRepository.save(member2);

        final Member member3 = new Member();
        member3.setName("spring3");
        this.memberRepository.save(member3);

        final Member member4 = new Member();
        member4.setName("spring4");
        this.memberRepository.save(member4);

        final Member member5 = new Member();
        member5.setName("spring5");
        this.memberRepository.save(member5);

        final Member member6 = new Member();
        member6.setName("spring6");
        this.memberRepository.save(member6);

        final Member member7 = new Member();
        member7.setName("spring7");
        this.memberRepository.save(member7);

        final Member member8 = new Member();
        member8.setName("spring8");
        this.memberRepository.save(member8);

        final Member member9 = new Member();
        member9.setName("spring9");
        this.memberRepository.save(member9);

        final Member member10 = new Member();
        member10.setName("spring10");
        this.memberRepository.save(member10);

        final Member member11 = new Member();
        member11.setName("spring11");
        this.memberRepository.save(member11);

        final Member member12 = new Member();
        member12.setName("spring12");
        this.memberRepository.save(member12);

        final Member member13 = new Member();
        member13.setName("spring13");
        this.memberRepository.save(member13);

        final Member member14 = new Member();
        member14.setName("spring14");
        this.memberRepository.save(member14);

        final Member member15 = new Member();
        member15.setName("spring15");
        this.memberRepository.save(member15);

        final Member member16 = new Member();
        member16.setName("spring16");
        this.memberRepository.save(member16);

        final Member member17 = new Member();
        member17.setName("spring17");
        this.memberRepository.save(member17);

        final Member member18 = new Member();
        member18.setName("spring18");
        this.memberRepository.save(member18);

        final Member member19 = new Member();
        member19.setName("spring19");
        this.memberRepository.save(member19);

        final Member member20 = new Member();
        member20.setName("spring20");
        this.memberRepository.save(member20);

        List<Member> result = this.memberRepository.findAll();
        assertThat(result).hasSize(20);
    }
}
