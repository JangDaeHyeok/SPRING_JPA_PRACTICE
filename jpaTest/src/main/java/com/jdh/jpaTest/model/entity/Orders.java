package com.jdh.jpaTest.model.entity;

import com.jdh.jpaTest.model.enums.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Temporal(TemporalType.DATE)
    private Date orderdate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
