package com.pair.customerService.dataAccess.abstracts;

import com.pair.customerService.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
