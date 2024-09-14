package net.dmfe.archsandbox.ioc;

import org.springframework.jdbc.core.JdbcOperations;

public class JdbcOperationsWithAnyMethodUserDao implements UserDao {

    private JdbcOperations jdbcOperations;

    public JdbcOperationsWithAnyMethodUserDao withJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        return this;
    }

}
