package com.project.petclinic.api.repository;

import com.project.petclinic.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int id);
}
