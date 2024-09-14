package net.dmfe.archsandbox.ioc;

import org.springframework.jdbc.core.JdbcOperations;

import java.util.Objects;

public class JdbcOperationsWithConstructorUserDao implements UserDao {

    private JdbcOperations jdbcOperations;

    public JdbcOperationsWithConstructorUserDao(JdbcOperations jdbcOperations) {
        this.jdbcOperations = Objects.requireNonNull(jdbcOperations);
    }
}
