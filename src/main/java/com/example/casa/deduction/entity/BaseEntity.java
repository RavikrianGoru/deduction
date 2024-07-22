package com.example.casa.deduction.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	// Below field is optional
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	
	@CreatedBy
	//@Column( nullable = false, updatable = false)
    private String createdBy;

	@Column( nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

	@Column(insertable=false)
    @LastModifiedBy
    private String lastModifiedBy;

	@Column(insertable=false)
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
