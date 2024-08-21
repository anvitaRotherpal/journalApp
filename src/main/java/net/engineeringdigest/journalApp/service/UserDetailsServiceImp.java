package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repositories.UserRepository;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImp implements UserDetailsServiceAutoConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user=userRepository.findUserName(username);
        if(user==null) {
            org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName()).password(user.getPassword())
                    .password(user.getPassword());
                     .roles(user.getRoles().toArray(new String[0]))
                    .build();
                     return userDetails;
        }
        throw new UsernameNotFoundException("User not found with username:" +username);
    }
}
