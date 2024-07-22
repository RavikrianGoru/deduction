package com.example.casa.deduction.entity;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the username or identifier of the current user
        // For example, you can get the username from the security context
        return Optional.of("current_user");
        //return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}