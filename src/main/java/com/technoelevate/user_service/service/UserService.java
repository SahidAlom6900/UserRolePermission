package com.technoelevate.user_service.service;

import java.util.List;

import com.technoelevate.user_service.dto.UserDto;
import com.technoelevate.user_service.entity.User;

public interface UserService {

	public User createOrUpdate(UserDto userDto);
	
	public User delete(Long deptId) ;
	
	public User getUser(Long deptId);
	
	public List<User> getAllUser();

}
