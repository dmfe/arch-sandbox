package net.dmfe.archsandbox.isp.functional;

import net.dmfe.archsandbox.isp.UserId;

public class UpdateUserPasswordService {

    private FindUserByIdSpi findUserByIdSpi;
    private UpdateUserSpi updateUserSpi;

    public void updateUserPassword(UserId id, String newPassword) {
        updateUserSpi.updateUser(findUserByIdSpi.findUserById(id)
                .map(userData -> userData.withPassword(newPassword))
                .orElseThrow());
    }
}
