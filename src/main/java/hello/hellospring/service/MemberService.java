package hello.hellospring.service;

import hello.hellospring.damain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(final Member member) {
        // 같은 이름이 있는 중복 회원은 안 된다.
        this.validateDuplicateMember(member);

        this.memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return this.memberRepository.findAll();
    }

    /**
     * 회원 조회
     */
    public Optional<Member> findOne(final Long memberId) {
        return this.memberRepository.findById(memberId);
    }

    /**
     * 중복회원 검증
     */
    private void validateDuplicateMember(Member member) {
        this.memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
}
