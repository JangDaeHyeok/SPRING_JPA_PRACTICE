package com.jdh.jpaTest.model.repository;

import com.jdh.jpaTest.model.entity.Delivery;
import com.jdh.jpaTest.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *
 */
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
