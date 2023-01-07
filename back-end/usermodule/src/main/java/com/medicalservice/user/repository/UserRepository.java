package com.medicalservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalservice.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
