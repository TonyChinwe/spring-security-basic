package com.phisoft.springsecuritybasicblogone.configuration;

import com.phisoft.springsecuritybasicblogone.security.AppPasswordEncoder;
import com.phisoft.springsecuritybasicblogone.security.AppUserDetailsManager;
import com.phisoft.springsecuritybasicblogone.security.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class ProjectConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }

    /**
     * Create user using the UserDetailsManager and returns the user to the context
     * @return The created UserDetailsManager with one user created
     */
    @Bean
    public UserDetailsManager userDetailsManager(){
        AppUserDetailsManager appUserDetailsManager=new AppUserDetailsManager();
        appUserDetailsManager.createUser(new User("tony","1234"));
        appUserDetailsManager.createUser(new User("frank","123"));
        return appUserDetailsManager;
    }

    /**
     * Create the password encoder
     * @return the password encoder created to the context
     */
    @Bean
    public AppPasswordEncoder passwordEncoder(){
        return new AppPasswordEncoder();
    }


}
