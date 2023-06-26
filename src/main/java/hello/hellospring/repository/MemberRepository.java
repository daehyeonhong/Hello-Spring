package hello.hellospring.repository;

import hello.hellospring.damain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(final Member member);

    Optional<Member> findById(final Long id);

    Optional<Member> findByName(final String name);

    List<Member> findAll();

    void clearStore();
}
