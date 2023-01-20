package com.practicas.personal.config;

import com.practicas.personal.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Autowired
    private PersonalService personalService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/index").permitAll()
                .requestMatchers("/registro").permitAll()
                .requestMatchers("/login/lista_user").permitAll()//hasRole("user")
                .requestMatchers("/login/lista_admin").permitAll()//hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll();
                //.and()
                //.logout().permitAll();//.invalidateHttpSession(true);
                //.clearAuthentication(true)
                //.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                //.logoutSuccessUrl("/login?logout").permitAll();
        return http.build();
    }
/*
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager user = new InMemoryUserDetailsManager();
        user.createUser(User.withUsername("admin")
                //.password(passwordEncoder().encode("nami"))
                .roles("admin")
                .build());
        //user.createUser(User.withUsername("user")
                //.roles("user")
                //.build());
        return user;
    }
*/

}
