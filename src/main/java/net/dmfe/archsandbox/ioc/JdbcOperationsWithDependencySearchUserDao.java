package net.dmfe.archsandbox.ioc;

import org.springframework.jdbc.core.JdbcOperations;

public class JdbcOperationsWithDependencySearchUserDao implements UserDao, DependencyFactoryAware {

    private JdbcOperations jdbcOperations;

    @Override
    public void setDependencyFactory(DependencyFactory dependencyFactory) {
        jdbcOperations = dependencyFactory.getDependency(JdbcOperations.class);
    }
}
