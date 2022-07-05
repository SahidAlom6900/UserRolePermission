package com.technoelevate.user_service.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(value = Include.NON_DEFAULT)
public class UserDto implements Serializable{
	
	private Long userId;

	private String firstName;

	private String lastName;

	private String gender;

	private List<RoleDto> roles;
}
