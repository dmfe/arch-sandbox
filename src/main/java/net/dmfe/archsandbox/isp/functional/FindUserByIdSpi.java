package net.dmfe.archsandbox.isp.functional;

import net.dmfe.archsandbox.isp.UserData;
import net.dmfe.archsandbox.isp.UserId;

import java.util.Optional;

public interface FindUserByIdSpi {

    Optional<UserData> findUserById(UserId id);

}
