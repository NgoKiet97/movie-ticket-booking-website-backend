package com.example.movieticketbooking.config;

import com.example.movieticketbooking.filter.JwtFilter;
import com.example.movieticketbooking.provider.CustomAuthenManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JwtFilter jwtFilter;

    @Autowired
    CustomAuthenManagerProvider customAuthenManagerProvider;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.getSharedObject((AuthenticationManagerBuilder.class))
                .authenticationProvider(customAuthenManagerProvider).build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .antMatchers("/file/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/signup/**").permitAll()
                .antMatchers("/role/**").permitAll()
                .antMatchers("/bill/**").permitAll()
                .antMatchers("/state-ticket/**").permitAll()
                .antMatchers("/type-ticket/**").permitAll()
                .antMatchers("/classification/**").permitAll()
                .antMatchers("/technology/**").permitAll()
                .antMatchers("/category/**").permitAll()
                .antMatchers("/cinema/**").permitAll()
                .antMatchers("/room/**").permitAll()
                .antMatchers("/seat/**").permitAll()
                .antMatchers("/movie/**").permitAll()
                .antMatchers("/show-movie/**").permitAll()
                .antMatchers("/ticket/**").permitAll()

                //Tất cả các link còn lại điều phải chứng thực
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

}
