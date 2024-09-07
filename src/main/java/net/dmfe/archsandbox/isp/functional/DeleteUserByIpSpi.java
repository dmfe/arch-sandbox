package net.dmfe.archsandbox.isp.functional;

import net.dmfe.archsandbox.isp.UserId;

public interface DeleteUserByIpSpi {

    void deleteUserById(UserId userId);

}
