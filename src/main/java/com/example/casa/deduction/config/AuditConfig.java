
package com.example.casa.deduction.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
//@EnableJpaAuditing
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
//This is used for custom auditing, implemented in AuditAwareImpl
public class AuditConfig {
	
	
}
