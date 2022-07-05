package com.technoelevate.user_service.service;

import java.util.List;

import com.technoelevate.user_service.dto.RoleDto;
import com.technoelevate.user_service.entity.Role;

public interface RoleService {

	public List<Role> createOrUpdateRole(List<RoleDto> RoleDtos) ;
	
	public Role getRole(Long empId);

	public Role delete(Long empId) ;

	public List<Role> getAllRole() ;

}
