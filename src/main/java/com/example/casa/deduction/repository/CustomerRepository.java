package com.example.casa.deduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.casa.deduction.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
