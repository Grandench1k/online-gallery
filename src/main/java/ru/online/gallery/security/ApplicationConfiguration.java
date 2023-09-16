package ru.online.gallery.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface ApplicationConfiguration {
    UserDetailsService userDetailsService();

    AuthenticationProvider authenticationProvider();

    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception;

    PasswordEncoder passwordEncoder();
}
