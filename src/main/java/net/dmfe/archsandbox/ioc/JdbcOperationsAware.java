package net.dmfe.archsandbox.ioc;

import org.springframework.jdbc.core.JdbcOperations;

public interface JdbcOperationsAware {

    void jdbcOperations(JdbcOperations jdbcOperations);

}
