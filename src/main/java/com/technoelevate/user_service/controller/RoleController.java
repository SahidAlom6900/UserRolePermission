package com.technoelevate.user_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technoelevate.user_service.dto.RoleDto;
import com.technoelevate.user_service.response.UserResponse;
import com.technoelevate.user_service.service.RoleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class RoleController {

	private final RoleService roleService;

	@PostMapping("role")
	public ResponseEntity<UserResponse> createRole(@RequestBody List<RoleDto> roleDtos) {
		return ResponseEntity.ok().body(
				UserResponse.builder().error(false).message("").data(roleService.createOrUpdateRole(roleDtos)).build());

	}

	@GetMapping("role/{roleId}")
	public ResponseEntity<UserResponse> getRole(@PathVariable(name = "roleId") Long roleId) {
		return ResponseEntity.ok()
				.body(UserResponse.builder().error(false).message("").data(roleService.getRole(roleId)).build());

	}

	@DeleteMapping("/role/{roleId}")
	public ResponseEntity<UserResponse> deleteRole(@PathVariable(name = "roleId") Long roleId) {
		return ResponseEntity.ok()
				.body(UserResponse.builder().error(false).message("").data(roleService.delete(roleId)).build());
	}

	@GetMapping(value = "/roles")
	public ResponseEntity<UserResponse> getAllRole() {
		return ResponseEntity.ok()
				.body(UserResponse.builder().error(false).message("").data(roleService.getAllRole()).build());
	}

}
