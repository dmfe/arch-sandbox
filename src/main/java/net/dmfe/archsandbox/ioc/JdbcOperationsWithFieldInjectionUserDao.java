package net.dmfe.archsandbox.ioc;

import org.springframework.jdbc.core.JdbcOperations;

public class JdbcOperationsWithFieldInjectionUserDao implements UserDao {

    JdbcOperations jdbcOperations;

}
