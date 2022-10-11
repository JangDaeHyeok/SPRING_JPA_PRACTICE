package com.jdh.jpaTest.model.repository;

import com.jdh.jpaTest.model.entity.Category;
import com.jdh.jpaTest.model.entity.Category_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *
 */
@Repository
public interface CategoryItemRepository extends JpaRepository<Category_item, Long> {
}
