package net.dmfe.archsandbox.isp;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findUserDataByUserName(username)
                .map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User with name %s not found".formatted(username)));
    }
}
