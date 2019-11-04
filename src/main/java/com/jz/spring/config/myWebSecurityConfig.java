package com.jz.spring.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jz
 * @date 2019/11/4 - 21:50
 */
@Configuration

@EnableWebSecurity
public class myWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder create() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/food").hasAnyAuthority("Food")
                .antMatchers("/profile").hasAnyAuthority("Profile")
                .antMatchers("/about").hasAnyAuthority("About")
                .antMatchers("/**").fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login").and()
                .csrf().disable();

        // .httpBasic();
    }
}
