package com.technoelevate.user_service.dto;

import java.io.Serializable;

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
public class PermissionDto implements Serializable {

	private Long permissionId;

	private String permissionName;

	private RoleDto role;
}
