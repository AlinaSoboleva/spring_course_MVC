package com.alina.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //используем дефолтное шифрование паролей (inMemory)
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("alina").password("alina").roles("EMPLOYEE"))
//                .withUser(userBuilder.username("elena").password("elena").roles("HR"))
//                .withUser(userBuilder.username("katya").password("katya").roles("MANAGER", "HR"));

        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests((authorizeRequest) ->
                {
                    try {
                        authorizeRequest.antMatchers("/").hasAnyRole("MANAGER", "EMPLOYEE", "HR") //что бы эту страницу видели все роли
                        .antMatchers("/hr_info").hasRole("HR")
                        .antMatchers("/manager_info").hasRole("MANAGER")
                                .and().formLogin().permitAll();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .exceptionHandling((exceptionHandling) ->
                        exceptionHandling.accessDeniedPage("/errors"));

        //форма логина и пароля запрашивается у всех
    }
}
