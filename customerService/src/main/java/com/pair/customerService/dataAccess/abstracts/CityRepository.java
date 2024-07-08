package com.pair.customerService.dataAccess.abstracts;

import com.pair.customerService.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
}
