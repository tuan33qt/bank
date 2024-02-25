package com.example.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/myaccount/**").hasRole("USER")
                        .requestMatchers("/api/mycustomer/**").hasAnyRole("USER","ADMIN")
                        .requestMatchers("api/mytransaction/**").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/api/myloan/**").hasRole("USER")
                        .requestMatchers("/api/mycard/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST,"api/myaccount","api/mycard","api/mycontact","api/myloan").
                        hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.PUT,"api/myaccount","api/mycard","api/mycontact","api/myloan").
                        hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"api/myaccount/**","api/mycard/**","api/mycontact/**","api/myloan/**","api/mycustomer/**").
                        hasRole("ADMIN")
                        .requestMatchers("api/mynotices","api/contact/**","/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
