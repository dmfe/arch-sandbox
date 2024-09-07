package net.dmfe.archsandbox.isp.functional;

import net.dmfe.archsandbox.isp.UserId;

public class WrongUpdateUserPasswordService {

    private UserDao userDao;

    public void updateUserPassword(UserId id, String newPassword) {
        userDao.updateUser(userDao.findUserById(id)
                .map(userData -> userData.withPassword(newPassword))
                .orElseThrow());
    }
}
