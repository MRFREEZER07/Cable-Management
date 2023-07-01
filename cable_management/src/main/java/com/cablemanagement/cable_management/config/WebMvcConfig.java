package com.cablemanagement.cable_management.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
//need to change a lot
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//     @Value("#{'${allowedorigins}'.split(',')}")
//     private List<String> allowedOrigin;
//     @Value("#{'${allowedorigins}'.split(',')}")
//     private List<String> allowedMethods;
//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//          CorsRegistration corsRegistration= registry.addMapping("/api/**");
//          allowedOrigin.forEach(corsRegistration::allowedOrigins);
//          allowedOrigin.forEach(corsRegistration::allowedMethods);
//     }
}
