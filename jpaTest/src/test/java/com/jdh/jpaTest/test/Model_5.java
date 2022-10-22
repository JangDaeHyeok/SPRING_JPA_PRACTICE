package com.jdh.jpaTest.test;

import com.jdh.jpaTest.model.entity.Delivery;
import com.jdh.jpaTest.model.entity.OrderItem;
import com.jdh.jpaTest.model.entity.Orders;
import com.jdh.jpaTest.model.repository.DeliveryRepository;
import com.jdh.jpaTest.model.repository.OrderItemRepository;
import com.jdh.jpaTest.model.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Slf4j
public class Model_5 {
    @Autowired OrdersRepository ordersRepository;
    @Autowired DeliveryRepository deliveryRepository;
    @Autowired OrderItemRepository orderItemRepository;

    @Test
    @DisplayName("영속성 전이 적용 전, 후 코드 비교")
    void 영속성_적용_전_테스트() {
        Delivery delivery = new Delivery();
        deliveryRepository.save(delivery); // persist

        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();
        orderItemRepository.save(orderItem1); // persist
        orderItemRepository.save(orderItem1); // persist

        Orders orders = new Orders();
        orders.setDelivery(delivery);
        orders.addOrderItem(orderItem1);
        orders.addOrderItem(orderItem2);
        ordersRepository.save(orders); // persist

        // transaction이 끝나면 commit 하면서 flush
    }

    @Test
    @DisplayName("영속성 전이 적용 전, 후 코드 비교")
    void 영속성_적용_후_테스트() {
        Delivery delivery = new Delivery();
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();

        Orders orders = new Orders();
        orders.setDelivery(delivery);
        orders.addOrderItem(orderItem1);
        orders.addOrderItem(orderItem2);
        ordersRepository.save(orders); // persist

        // transaction이 끝나면 commit 하면서 flush
        // flush 시점에 delivery, orderItems 영속성 전이
    }
}
