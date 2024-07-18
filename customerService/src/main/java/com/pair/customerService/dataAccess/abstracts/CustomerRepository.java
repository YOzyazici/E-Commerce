package com.pair.customerService.dataAccess.abstracts;

import com.pair.customerService.entities.concretes.Customer;
import feign.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.isActive = false WHERE c.id = :id")
    void softDelete(UUID id);

    @Query("SELECT CASE WHEN c.isActive = true THEN true ELSE false END FROM Customer c WHERE c.id = :id")
    Boolean isActiveCustomer(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.isActive = true WHERE c.id = :id")
    void setActiveCustomer(UUID id);
}
