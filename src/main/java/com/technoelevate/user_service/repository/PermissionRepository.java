package com.technoelevate.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technoelevate.user_service.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
	public Optional<Permission> findByPermissionName(String permissionName);
}
