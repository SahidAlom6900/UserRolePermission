package com.technoelevate.user_service.controller;

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

import com.technoelevate.user_service.dto.UserDto;
import com.technoelevate.user_service.response.RoleResponse;
import com.technoelevate.user_service.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping(path = "user")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<RoleResponse> createDepartment(@RequestBody UserDto userDto) {
		return ResponseEntity
				.ok(RoleResponse.builder().error(false).message("").data(userService.createOrUpdate(userDto)).build());
	}

	@GetMapping(path = "user/{userId}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<RoleResponse> getDepartment(@PathVariable(name = "userId") Long userId) {
		return ResponseEntity
				.ok(RoleResponse.builder().error(false).message("").data(userService.getUser(userId)).build());
	}

	@DeleteMapping(path = "user/{userId}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<RoleResponse> deleteDepartment(@PathVariable(name = "userId") Long userId) {
		return ResponseEntity
				.ok(RoleResponse.builder().error(false).message("").data(userService.delete(userId)).build());
	}

	@GetMapping(path = "users")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<RoleResponse> getAllDepartment() {
		return ResponseEntity
				.ok(RoleResponse.builder().error(false).message("").data(userService.getAllUser()).build());
	}

}
