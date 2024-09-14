package net.dmfe.archsandbox.ioc;

import org.springframework.jdbc.core.JdbcOperations;

public class UserBeans {

    private DependencyFactory dependencyFactory;

    // constructor injection
    public UserDao userDaoWithConstructor() {
        return new JdbcOperationsWithConstructorUserDao(dependencyFactory.getDependency(JdbcOperations.class));
    }

    // set method injection
    public UserDao userDaoWithSetMethod() {
        var userDao = new JdbcOperationsWithSetMethodUserDao();
        userDao.setJdbcOperations(dependencyFactory.getDependency(JdbcOperations.class));
        return userDao;
    }

    // injection interface
    public UserDao userDaoWithInjectionInterface() {
        var userDao = new JdbcOperationsWithInjectionInterfaceUserDao();
        if (userDao instanceof JdbcOperationsAware jdbcOperationsAware) {
            jdbcOperationsAware.jdbcOperations(dependencyFactory.getDependency(JdbcOperations.class));
        }
        return userDao;
    }

    // any method
    public UserDao userDaoWithAnyMethod() {
        return new JdbcOperationsWithAnyMethodUserDao()
                .withJdbcOperations(dependencyFactory.getDependency(JdbcOperations.class));
    }

    // field injection (bad thing - encapsulation violation)
    public UserDao userDaoWithFieldInjection() {
        var userDao = new JdbcOperationsWithFieldInjectionUserDao();
        userDao.jdbcOperations = dependencyFactory.getDependency(JdbcOperations.class);
        return userDao;
    }

    // dependency search
    public UserDao userDaoWithDependencySearch() {
        var userDao = new JdbcOperationsWithDependencySearchUserDao();
        userDao.setDependencyFactory(dependencyFactory);
        return userDao;
    }
}
