package net.dmfe.archsandbox.ioc;

import org.springframework.jdbc.core.JdbcOperations;

public class JdbcOperationsWithInjectionInterfaceUserDao implements UserDao, JdbcOperationsAware {

    private JdbcOperations jdbcOperations;

    @Override
    public void jdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

}
