package com.cablemanagement.cable_management.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Getter

public class SecurityConfig {



    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    public SecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //need to export to env or to DB
    private String  username ="admin";
    private String password ="text";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //csrf enabled by default
                .csrf().disable()
                .authorizeRequests()
                // no one can acces delete method except admin
                .requestMatchers(HttpMethod.DELETE).hasRole("admin")
                .requestMatchers(HttpMethod.POST).hasRole("admin")
                .requestMatchers(HttpMethod.GET).permitAll()
                .anyRequest().authenticated()
                .and()
                //no sessions created
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .httpBasic(withDefaults());



                return http.build();
    }



    @Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .roles("admin")
                .build();

//        UserDetails user = User.builder()
//                .username("karthik")
//                .password(bCryptPasswordEncoder.encode("samantha"))
//                .roles("user")
//                .build();
        return new  InMemoryUserDetailsManager(admin);
    }



}
