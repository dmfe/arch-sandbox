package net.dmfe.archsandbox.ioc;

import org.springframework.jdbc.core.JdbcOperations;

public class JdbcOperationsWithSetMethodUserDao implements UserDao {

    private JdbcOperations jdbcOperations;

    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

}
