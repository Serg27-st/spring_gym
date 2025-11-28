package com.example.spring_gym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpingBootSecurity {

    @Autowired
    private UserDetailsService userDetailService;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = 
            http.getSharedObject(AuthenticationManagerBuilder.class);

        auth.userDetailsService(userDetailService)
            .passwordEncoder(getEnecoder());

        return auth.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/administrador/**").hasRole("ADMIN")
                .requestMatchers("/inventarios/**").hasRole("ADMIN")
                .anyRequest().permitAll()
            )
            .formLogin(login -> login
                .loginPage("/socio/login")
                .defaultSuccessUrl("/socio/acceder", true)
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder getEnecoder() {
        return new BCryptPasswordEncoder();
    }
}