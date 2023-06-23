package com.nickgonzalez.trainhsr.dao;

import com.nickgonzalez.trainhsr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}