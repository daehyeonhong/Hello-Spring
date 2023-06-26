package hello.hellospring.repository;

import hello.hellospring.damain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(final Member member) {
        final SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        final var parameters = new HashMap<String, Object>();
        parameters.put("name", member.getName());

        final Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
        member.setId(key.longValue());
        return member;
    }

    @Override
    public Optional<Member> findById(final Long id) {
        final List<Member> result = this.jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
        return result.stream().findAny();
    }

    private RowMapper<Member> memberRowMapper() {
        return (resultSet, rowNum) -> {
            final Member member = new Member();
            member.setId(resultSet.getLong("id"));
            member.setName(resultSet.getString("name"));
            return member;
        };
    }

    @Override
    public Optional<Member> findByName(final String name) {
        final List<Member> result = this.jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return this.jdbcTemplate.query("select * from member", memberRowMapper());
    }

    @Override
    public void clearStore() {

    }
}
