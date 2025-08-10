package com.robert.springSecurityLearn.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//        httpSecurity.csrf(customizer -> customizer.disable());
//        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//        httpSecurity.formLogin(Customizer.withDefaults());
//        httpSecurity.httpBasic(Customizer.withDefaults());
//
//        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return httpSecurity.build();

        // Using Builder pattern
        return httpSecurity
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}

/**
 * Internal way of each & every method actual implementation structure
 * Customizer<CsrfConfigurer<HttpSecurity>> csrfConfigurerCustomizer = new Customizer<CsrfConfigurer<HttpSecurity>>() {
 *             @Override
 *             public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
 *                 httpSecurityCsrfConfigurer.disable();
 *             }
 *         };
 *         httpSecurity.csrf(csrfConfigurerCustomizer);
 *
 */