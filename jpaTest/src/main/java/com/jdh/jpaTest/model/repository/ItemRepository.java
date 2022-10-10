package com.jdh.jpaTest.model.repository;

import com.jdh.jpaTest.model.entity.Item;
import com.jdh.jpaTest.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
