package com.spring_web.test_web.repositories;

import com.spring_web.test_web.entities.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageRepository extends JpaRepository<PageEntity, Long> {


    Optional<PageEntity> findByTitle(String title);
}
