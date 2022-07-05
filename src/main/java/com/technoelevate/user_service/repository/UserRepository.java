package com.technoelevate.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technoelevate.user_service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
