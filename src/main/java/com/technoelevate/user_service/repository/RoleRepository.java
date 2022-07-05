package com.technoelevate.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technoelevate.user_service.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
 
	public Optional<Role> findByRoleName(String roleName);
}
