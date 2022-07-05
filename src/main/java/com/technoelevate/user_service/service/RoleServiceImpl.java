package com.technoelevate.user_service.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.technoelevate.user_service.dto.PermissionDto;
import com.technoelevate.user_service.dto.RoleDto;
import com.technoelevate.user_service.entity.Permission;
import com.technoelevate.user_service.entity.Role;
import com.technoelevate.user_service.repository.PermissionRepository;
import com.technoelevate.user_service.repository.RoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	private PermissionRepository permissionRepository;

	@Override
	public List<Role> createOrUpdateRole(List<RoleDto> roleDtos) {
		List<Role> roles = new ArrayList<>();
		roleDtos.stream().forEach(rol -> {
			Role role = roleRepository.findByRoleName(rol.getRoleName())
					.orElse(Role.builder().roleName(rol.getRoleName()).build());
			List<Permission> permissions = new ArrayList<>();
			List<PermissionDto> permissionDtos = rol.getPermissions() == null ? Collections.emptyList()
					: rol.getPermissions();
			permissionDtos.stream().forEach(perm -> {
				Permission permission = permissionRepository.findByPermissionName(perm.getPermissionName())
						.orElse(Permission.builder().permissionName(perm.getPermissionName()).build());
				permissions.add(permission);
			});
			List<Permission> permission = permissionRepository
					.saveAll(permissionDtos.isEmpty() ? role.getPermissions() : permissions);
			role.setPermissions(permission);
			roles.add(role);
		});
		return roleRepository.saveAll(roles);
	}

	@Override
	public Role getRole(Long roleId) {
		return roleRepository.findById(roleId == null ? 0 : roleId).orElseThrow(IllegalStateException::new);
	}

	@Override
	public Role delete(Long roleId) {
		Role role = roleRepository.findById(roleId == null ? 0 : roleId).orElseThrow(IllegalStateException::new);
		roleRepository.delete(role);
		return role;
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

}
