package com.phisoft.springsecuritybasicblogone.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.ArrayList;
import java.util.List;


/**
 * This manages the application users
 *
 */
public class AppUserDetailsManager implements UserDetailsManager {

    private List<UserDetails> userDetailsList=new ArrayList<>();

    @Override
    public void createUser(UserDetails userDetails) {
      userDetailsList.add(userDetails);
    }

    @Override
    public void updateUser(UserDetails userDetails) {
        //TODO Left this for now

    }

    @Override
    public void deleteUser(String s) {
        //TODO Left this for now

    }

    @Override
    public void changePassword(String s, String s1) {
       //TODO Left this for now
    }

    @Override
    public boolean userExists(String s) {
        return userDetailsList.stream().anyMatch(u->u.getUsername().equals(s));

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDetailsList.stream()
                .filter(u->u.getUsername().equals(s))
                .findFirst().orElseThrow(()->new UsernameNotFoundException("Username not found"));

    }
}
