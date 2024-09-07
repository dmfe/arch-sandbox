package net.dmfe.archsandbox.isp.functional;

import net.dmfe.archsandbox.isp.UserData;

import java.util.Optional;

public interface FindUserByUserNameSpi {

    Optional<UserData> findUserByUserName(String userName);
}
