package com.example.CursosCapacitacion.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails empleado = User.withUsername("empleado")
                .password(passwordEncoder.encode("empleado123"))
                .roles("EMPLEADO")
                .build();

        return new InMemoryUserDetailsManager(admin, empleado);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // CSRF: lo ignoramos para H2 y para API REST
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**", "/api/**")
                )
                // H2 console
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin())
                )
                .authorizeHttpRequests(auth -> auth
                        // Recursos públicos
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "/h2-console/**").permitAll()
                        .requestMatchers("/login").permitAll()

                        // API REST (GET /api/cursos, POST /api/inscripciones)
                        .requestMatchers("/api/cursos", "/api/inscripciones").hasAnyRole("ADMIN", "EMPLEADO")

                        // Rutas Web MVC
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/empleado/**").hasRole("EMPLEADO")

                        // Cualquier otra petición debe estar autenticada
                        .anyRequest().authenticated()
                )
                // Basic Auth para el API
                .httpBasic(Customizer.withDefaults())
                // Form login para la parte web
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(customAuthenticationSuccessHandler())
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return (HttpServletRequest request,
                HttpServletResponse response,
                org.springframework.security.core.Authentication authentication) -> {

            String redirectUrl = "/empleado/cursos"; // por defecto

            for (GrantedAuthority authority : authentication.getAuthorities()) {
                String role = authority.getAuthority();
                if ("ROLE_ADMIN".equals(role)) {
                    redirectUrl = "/admin/cursos";
                    break;
                } else if ("ROLE_EMPLEADO".equals(role)) {
                    redirectUrl = "/empleado/cursos";
                }
            }

            try {
                response.sendRedirect(request.getContextPath() + redirectUrl);
            } catch (IOException e) {
                throw new ServletException("Error en redirección post-login", e);
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}