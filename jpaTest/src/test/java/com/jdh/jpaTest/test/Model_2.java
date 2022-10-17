//package com.jdh.jpaTest.test;
//
//import com.jdh.jpaTest.model.entity.Item;
//import com.jdh.jpaTest.model.entity.Member;
//import com.jdh.jpaTest.model.entity.OrderItem;
//import com.jdh.jpaTest.model.entity.Orders;
//import com.jdh.jpaTest.model.enums.OrderStatus;
//import com.jdh.jpaTest.model.repository.ItemRepository;
//import com.jdh.jpaTest.model.repository.MemberRepository;
//import com.jdh.jpaTest.model.repository.OrderItemRepository;
//import com.jdh.jpaTest.model.repository.OrdersRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Slf4j
//public class Model_2 {
//    @Autowired MemberRepository memberRepository;
//    @Autowired OrdersRepository ordersRepository;
//    @Autowired OrderItemRepository orderItemRepository;
//    @Autowired ItemRepository itemRepository;
//
//    @Test
//    @Order(1)
//    @DisplayName("Data Insert")
//    @Transactional // 영속성 컨텍스트 유지하여 지연 로딩을 하기 위해 트랜잭션 안에서 실행
//    void save() {
//        // order entity
//        Orders orders = new Orders();
//        orders.setOrderdate(new Date());
//        orders.setStatus(OrderStatus.ORDER);
//
//        // member select
//        Optional<Member> member = memberRepository.findById(9L);
//        if(member.isPresent()) {
//            orders.setMember(member.get());
//        }
//
//        // order insert
//        ordersRepository.save(orders);
//
//        // item entity
//        Item item = new Item();
//        item.setName("아이템1");
//        item.setPrice(1000);
//        item.setStockQuantity(10);
//        // item insert
//        itemRepository.save(item);
//
//        // order item entity
//        OrderItem orderItem = new OrderItem();
//        orderItem.setItem(item);
//        orderItem.setOrders(orders);
//        orderItem.setOrderprice(3000);
//        orderItem.setCount(3);
//        // order item insert
//        orderItemRepository.save(orderItem);
//
//        // data select
//        select();
//    }
//
//    void select() {
//        List<OrderItem> orderItemList = orderItemRepository.findAll();
//        for(var result : orderItemList) {
//            log.info("[Model_2] find => member_name : {}, order_date : {}, order_status : {}, order_price : {}, count : {}, item_name : {}"
//                        , result.getOrders().getMember().getName(), result.getOrders().getOrderdate(), result.getOrders().getStatus(), result.getOrderprice()
//                        , result.getCount(), result.getItem().getName());
//        }
//    }
//}
