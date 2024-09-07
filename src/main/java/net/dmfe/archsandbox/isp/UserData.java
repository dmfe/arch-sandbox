package net.dmfe.archsandbox.isp;

public record UserData(UserId userid, String username, String password) {

    public UserData withPassword(String newPassword) {
        return new UserData(userid, username, newPassword);
    }

}
