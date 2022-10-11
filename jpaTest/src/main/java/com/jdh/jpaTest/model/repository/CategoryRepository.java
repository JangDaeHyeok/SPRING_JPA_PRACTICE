package com.jdh.jpaTest.model.repository;

import com.jdh.jpaTest.model.entity.Category;
import com.jdh.jpaTest.model.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
