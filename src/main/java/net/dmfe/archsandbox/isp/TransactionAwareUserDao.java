package net.dmfe.archsandbox.isp;

import org.springframework.transaction.support.TransactionOperations;

import java.util.List;
import java.util.Optional;

public class TransactionAwareUserDao implements UserDao {

    private final UserDao userDao;
    private final TransactionOperations transactionOperations;

    public TransactionAwareUserDao(UserDao userDao, TransactionOperations transactionOperations) {
        this.userDao = userDao;
        this.transactionOperations = transactionOperations;
    }

    @Override
    public Optional<UserData> findUserDataById(UserId id) {
        return userDao.findUserDataById(id);
    }

    @Override
    public Optional<UserData> findUserDataByUserName(String username) {
        return userDao.findUserDataByUserName(username);
    }

    @Override
    public List<UserData> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveUserData(UserData userData) {
        transactionOperations.executeWithoutResult(status -> userDao.saveUserData(userData));
    }

    @Override
    public void updateUserData(UserData userData) {
        transactionOperations.executeWithoutResult(status -> userDao.updateUserData(userData));
    }

    @Override
    public void deleteUserById(UserId id) {
        transactionOperations.executeWithoutResult(status -> userDao.deleteUserById(id));
    }

}
