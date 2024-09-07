package net.dmfe.archsandbox.isp;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<UserData> findUserDataById(UserId id);

    Optional<UserData> findUserDataByUserName(String username);

    List<UserData> findAll();

    void saveUserData(UserData userData);

    void updateUserData(UserData userData);

    void deleteUserById(UserId id);
}
