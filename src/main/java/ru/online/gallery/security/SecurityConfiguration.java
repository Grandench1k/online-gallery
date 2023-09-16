package ru.online.gallery.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public interface SecurityConfiguration {
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception;
}
