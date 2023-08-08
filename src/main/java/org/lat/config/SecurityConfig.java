package org.lat.config;

import lombok.RequiredArgsConstructor;
import org.lat.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers(HttpMethod.GET,"/lat/**").permitAll()
                                .requestMatchers(HttpMethod.POST,"/lat/**").hasAnyAuthority("ADMIN", "PROFESOR")
                                .requestMatchers(HttpMethod.PUT, "/lat/usuario/**").hasAnyAuthority("ADMIN", "PROFESOR", "ALUMNO")
                                .requestMatchers(HttpMethod.PUT, "/lat/**").hasAnyAuthority("ADMIN", "PROFESOR")
                                .requestMatchers(HttpMethod.DELETE, "/lat/usuario/**").hasAnyAuthority("ADMIN", "PROFESOR", "ALUMNO")
                                .requestMatchers(HttpMethod.DELETE,"/lat/**").hasAnyAuthority("ADMIN", "PROFESOR")
                                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .cors().and()
                .build();
    }
}
