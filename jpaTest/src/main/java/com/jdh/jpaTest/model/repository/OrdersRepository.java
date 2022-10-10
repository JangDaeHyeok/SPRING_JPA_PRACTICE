package com.jdh.jpaTest.model.repository;

import com.jdh.jpaTest.model.entity.Member;
import com.jdh.jpaTest.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
