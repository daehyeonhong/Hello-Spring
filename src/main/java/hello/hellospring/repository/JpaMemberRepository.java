package hello.hellospring.repository;

import hello.hellospring.damain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public class JpaMemberRepository implements MemberRepository {
    private final EntityManager entityManager;

    public JpaMemberRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Member save(final Member member) {
        this.entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(final Long id) {
        final Member member = this.entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(final String name) {
        final List<Member> result = this.entityManager.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return this.entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public void clearStore() {

    }
}
