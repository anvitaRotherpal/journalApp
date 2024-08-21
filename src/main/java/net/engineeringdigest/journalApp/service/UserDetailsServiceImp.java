package net.engineeringdigest.journalApp.service;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

public class UserDetailsServiceImp implements UserDetailsServiceAutoConfiguration {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return null;
    }
}
