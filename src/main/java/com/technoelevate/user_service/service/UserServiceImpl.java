package com.technoelevate.user_service.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.technoelevate.user_service.dto.PermissionDto;
import com.technoelevate.user_service.dto.UserDto;
import com.technoelevate.user_service.entity.Permission;
import com.technoelevate.user_service.entity.Role;
import com.technoelevate.user_service.entity.User;
import com.technoelevate.user_service.repository.PermissionRepository;
import com.technoelevate.user_service.repository.RoleRepository;
import com.technoelevate.user_service.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private RoleRepository roleRepository;

	private UserRepository userRepository;

	private PermissionRepository permissionRepository;

	@Override
	public User createOrUpdate(UserDto userDto) {
		User user = userRepository.findById(userDto.getUserId() == null ? 0 : userDto.getUserId())
				.orElse(User.builder().build());
		List<Role> roles = new ArrayList<>();
		BeanUtils.copyProperties(userDto, user);
		userDto.getRoles().stream().forEach(rol -> {
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
		List<Role> roleList = roleRepository.saveAll(roles);
		user.setRoles(roleList);
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User delete(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(IllegalStateException::new);
		userRepository.delete(user);
		return user;
	}

	@Override
	public User getUser(Long userId) {
		return userRepository.findById(userId).orElseThrow(IllegalStateException::new);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
