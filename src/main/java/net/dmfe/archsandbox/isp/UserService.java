package net.dmfe.archsandbox.isp;

public class UserService {

    private UserDao userDao;

    public void updateUserPassword(UserId userId, String newPassword) {
        userDao.updateUserData(userDao.findUserDataById(userId)
                .map(user -> user.withPassword(newPassword))
                .orElseThrow());
    }

    public void deleteUser(UserId userId) {
        userDao.deleteUserById(userId);
    }
}
