package com.pair.authService.dataAccess.abstracts;


import com.pair.authService.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
