package hello.hellospring.service;

import hello.hellospring.damain.Member;
import hello.hellospring.repository.MemberRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private static final Logger log = LogManager.getLogger(MemberService.class);
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(final Member member) {
        final long start = System.currentTimeMillis();
        try {
            this.validateDuplicateMember(member);

            this.memberRepository.save(member);
            return member.getId();
        } finally {
            final long finish = System.currentTimeMillis();
            final long timeMilliseconds = finish - start;
            log.info("join = {}ms", timeMilliseconds);
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        final long start = System.currentTimeMillis();
        try {
            return this.memberRepository.findAll();
        } finally {
            final long finish = System.currentTimeMillis();
            final long timeMilliseconds = finish - start;
            log.info("findMembers = {}ms", timeMilliseconds);
        }
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
