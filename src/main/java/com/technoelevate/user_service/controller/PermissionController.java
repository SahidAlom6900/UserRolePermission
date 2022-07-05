package com.technoelevate.user_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.technoelevate.user_service.dto.PermissionDto;
import com.technoelevate.user_service.response.RoleResponse;
import com.technoelevate.user_service.service.PermissionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class PermissionController {

	private final PermissionService permissionService;

	@PostMapping(path = "permission")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<RoleResponse> createDepartment(@RequestBody List<PermissionDto> permissionDtos) {
		return ResponseEntity
				.ok(RoleResponse.builder().error(false).message("").data(permissionService.createOrUpdate(permissionDtos)).build());
	}

	@GetMapping(path = "permission/{permissionId}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<RoleResponse> getDepartment(@PathVariable(name = "permissionId") Long permissionId) {
		return ResponseEntity
				.ok(RoleResponse.builder().error(false).message("").data(permissionService.getPermission(permissionId)).build());
	}

	@DeleteMapping(path = "permission/{permissionId}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<RoleResponse> deleteDepartment(@PathVariable(name = "permissionId") Long permissionId) {
		return ResponseEntity
				.ok(RoleResponse.builder().error(false).message("").data(permissionService.delete(permissionId)).build());
	}

	@GetMapping(path = "permissions")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<RoleResponse> getAllDepartment() {
		return ResponseEntity
				.ok(RoleResponse.builder().error(false).message("").data(permissionService.getAllPermission()).build());
	}

}
