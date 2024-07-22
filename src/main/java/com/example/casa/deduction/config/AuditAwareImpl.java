package com.example.casa.deduction.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String>{

	@Override
    public Optional<String> getCurrentAuditor() {
        // Return the username or identifier of the current user, if we can get current_user:  username from the security context
        return Optional.of("current_user");
        //return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
