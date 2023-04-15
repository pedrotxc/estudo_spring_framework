package com.api.parkingcontrol.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().anyRequest().permitAll(); (PERMITE QUALQUER CHAMADA)
//        http.httpBasic().and().authorizeHttpRequests().anyRequest().authenticated(); (NECESSÁRIO PASSAR O USUÁRIO E SENHA)
        http.httpBasic().and().authorizeHttpRequests().anyRequest().authenticated().and().csrf().disable();
        return http.build();
    }

}
