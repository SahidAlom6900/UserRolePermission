package com.technoelevate.user_service.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.technoelevate.user_service.dto.PermissionDto;
import com.technoelevate.user_service.entity.Permission;
import com.technoelevate.user_service.repository.PermissionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

	private PermissionRepository permissionRepository;

	@Override
	public List<Permission> createOrUpdate(List<PermissionDto> permissionDtos) {
		List<Permission> permissions = new ArrayList<>();
		List<PermissionDto> permissionDtoLidt = permissionDtos == null ? Collections.emptyList() : permissionDtos;
		permissionDtoLidt.stream().forEach(perm -> {
			Permission permission = permissionRepository.findByPermissionName(perm.getPermissionName())
					.orElse(Permission.builder().permissionName(perm.getPermissionName()).build());
			permissions.add(permission);
		});
		if (permissionDtoLidt.isEmpty())
			return Collections.emptyList();
		return permissionRepository.saveAll(permissions);
	}

	@Override
	public Permission getPermission(Long permissionId) {
		return permissionRepository.findById(permissionId).orElseThrow(IllegalStateException::new);
	}

	@Override
	public Permission delete(Long permissionId) {
		Permission permission = permissionRepository.findById(permissionId).orElseThrow(IllegalStateException::new);
		permissionRepository.delete(permission);
		return permission;
	}

	@Override
	public List<Permission> getAllPermission() {
		return permissionRepository.findAll();
	}

}
