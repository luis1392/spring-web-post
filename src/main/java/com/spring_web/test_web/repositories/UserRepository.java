package com.spring_web.test_web.repositories;

import com.spring_web.test_web.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
