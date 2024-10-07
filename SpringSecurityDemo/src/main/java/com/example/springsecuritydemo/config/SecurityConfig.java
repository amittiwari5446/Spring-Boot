package com.example.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authorize->
                    authorize.requestMatchers("/public/**").permitAll() // Public pages accessible without authentication
                            .requestMatchers("/admin/**").hasRole("ADMIN") // Only ADMIN role can access /admin/**
                            .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(form-> form
                        .loginPage("/login") // Custom login page
                        .permitAll()
                )
                .logout(logout->logout
                        .permitAll()
                );
                return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user= User.withUsername("user")
                .password("{noop}password")
                .roles("USER")
                .build();
        UserDetails admin= User.withUsername("admin")
                .password("{noop}admin@123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
