package com.airtribe.ems.config;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(11);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                        .requestMatchers("/register").permitAll()
//                        .anyRequest().authenticated())
//                .formLogin(formLogin -> formLogin.defaultSuccessUrl("/health", true).permitAll());
//        return http.build();
//    }
}
