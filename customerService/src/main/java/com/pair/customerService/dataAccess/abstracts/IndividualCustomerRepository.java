package com.pair.customerService.dataAccess.abstracts;

import com.pair.customerService.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, UUID> {

    Optional<IndividualCustomer> findByNationalityNo(String nationalityNo);

    @Query("""
            SELECT ic FROM IndividualCustomer ic 
            JOIN FETCH ic.customer c
            WHERE c.isActive = true
            """)
    List<IndividualCustomer> findAllActiveIndividualCustomers();

    @Query("""
            SELECT ic FROM IndividualCustomer ic 
            JOIN FETCH ic.customer c
            WHERE c.isActive = true
            AND ic.id = :id
            """)
    Optional<IndividualCustomer> findByIdActiveIndividualCustomers(UUID id);
}
