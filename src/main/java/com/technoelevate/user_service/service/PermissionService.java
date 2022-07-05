package com.technoelevate.user_service.service;

import java.util.List;

import com.technoelevate.user_service.dto.PermissionDto;
import com.technoelevate.user_service.entity.Permission;

public interface PermissionService {
	
	public List<Permission> createOrUpdate(List<PermissionDto> permissionDtos);

	public Permission getPermission(Long permissionId);

	public Permission delete(Long permissionId);

	public List<Permission> getAllPermission();
}
