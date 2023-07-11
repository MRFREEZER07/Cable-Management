package com.cablemanagement.cable_management.web;
import com.cablemanagement.cable_management.security.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Auth {

    private SecurityConfig securityConfig;
    @GetMapping("api/v1/auth")
    public String auth(Authentication authentication){
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println(password);
        if(securityConfig.getUsername().equals(username) && securityConfig.getPassword().equals(authentication.getCredentials())){
            return "hey";
        }else{
            return "not ghey";
        }

    }
}
