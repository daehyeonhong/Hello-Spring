package hello.hellospring.repository;

import hello.hellospring.damain.Member;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements MemberRepository {
    private final DataSource dataSource;

    public JdbcMemberRepository(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(final Member member) {
        final String sql = "insert into member(name) values(?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.getconnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, member.getName());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                member.setId(resultSet.getLong(1));
                return member;
            } else {
                throw new SQLException("id 조회 실패");
            }
        } catch (final Exception exception) {
            throw new IllegalArgumentException(exception);
        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    private void close(final Connection connection, final PreparedStatement preparedStatement, final ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        if (connection != null) close(connection);
    }

    private void close(final Connection connection) {
        DataSourceUtils.releaseConnection(connection, dataSource);
    }

    private Connection getconnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    @Override
    public Optional<Member> findById(final Long id) {
        final String sql = "select * from member where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getconnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final Member member = new Member();
                member.setId(resultSet.getLong("id"));
                member.setName(resultSet.getString("name"));
                return Optional.of(member);
            } else {
                return Optional.empty();
            }
        } catch (final Exception exception) {
            throw new IllegalArgumentException(exception);
        } finally {
            this.close(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public Optional<Member> findByName(final String name) {
        final String sql = "select * from member where name = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getconnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final Member member = new Member();
                member.setId(resultSet.getLong("id"));
                member.setName(resultSet.getString("name"));
                return Optional.of(member);
            } else {
                return Optional.empty();
            }
        } catch (final Exception exception) {
            throw new IllegalArgumentException(exception);
        } finally {
            this.close(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Member> findAll() {
        final String sql = "select * from member";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getconnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            final List<Member> members = new ArrayList<>();

            while (resultSet.next()) {
                final Member member = new Member();
                member.setId(resultSet.getLong("id"));
                member.setName(resultSet.getString("name"));
                members.add(member);
            }
            return members;
        } catch (final Exception exception) {
            throw new IllegalArgumentException(exception);
        } finally {
            this.close(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void clearStore() {

    }
}
