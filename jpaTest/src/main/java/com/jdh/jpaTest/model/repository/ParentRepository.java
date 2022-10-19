package com.jdh.jpaTest.model.repository;

import com.jdh.jpaTest.model.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *
 */
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
}
