package com.example.casa.deduction.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casa.deduction.entity.CustomerEntity;
import com.example.casa.deduction.repository.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	private static final Logger auditLogger = LoggerFactory.getLogger("AUDIT");

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerEntity> findAll() {
		try {
			List<CustomerEntity> customers = customerRepository.findAll();
			auditLogger.info("Audit Log: Retrieved all customers");
			return customers;
		} catch (Exception e) {
			logger.error("Error fetching all customers: {}", e.getMessage(), e);
			auditLogger.error("Audit Error Log: Error fetching all customers: {}", e.getMessage(), e);
			throw e;
		}
	}

	public Optional<CustomerEntity> findById(Long id) {
        try {
            Optional<CustomerEntity> customer = customerRepository.findById(id);
            auditLogger.info("Audit Log: Retrieved customer with id {}", id);
            return customer;
        } catch (Exception e) {
            logger.error("Error fetching customer with id {}: {}", id, e.getMessage(), e);
            auditLogger.error("Audit Error Log: Error fetching customer with id {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public CustomerEntity save(CustomerEntity customer) {
        try {
            CustomerEntity savedCustomer = customerRepository.save(customer);
            auditLogger.info("Audit Log: Saved customer with id {}", savedCustomer.getId());
            return savedCustomer;
        } catch (Exception e) {
            logger.error("Error saving customer: {}", e.getMessage(), e);
            auditLogger.error("Audit Error Log: Error saving customer: {}", e.getMessage(), e);
            throw e;
        }
    }

    public void deleteById(Long id) {
        try {
            customerRepository.deleteById(id);
            auditLogger.info("Audit Log: Deleted customer with id {}", id);
        } catch (Exception e) {
            logger.error("Error deleting customer with id {}: {}", id, e.getMessage(), e);
            auditLogger.error("Audit Error Log: Error deleting customer with id {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }
}
