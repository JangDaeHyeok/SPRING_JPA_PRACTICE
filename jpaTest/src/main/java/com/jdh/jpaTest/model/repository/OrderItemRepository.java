package com.jdh.jpaTest.model.repository;

import com.jdh.jpaTest.model.entity.OrderItem;
import com.jdh.jpaTest.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
