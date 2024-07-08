package com.pair.customerService.dataAccess.abstracts;

import com.pair.customerService.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
