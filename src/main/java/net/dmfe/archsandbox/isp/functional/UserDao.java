package net.dmfe.archsandbox.isp.functional;

public interface UserDao extends DeleteUserByIpSpi, FindUserByIdSpi, FindUserByUserNameSpi,
        FindUsersSpi, SaveUserSpi, UpdateUserSpi {
}
