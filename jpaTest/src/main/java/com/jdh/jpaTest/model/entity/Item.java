package com.jdh.jpaTest.model.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DynamicUpdate
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<Category_item> categoryItemList = new ArrayList<>();

    // s :: 별도의 연결 엔티티를 사용하지 않는 경우 :: //
    /*
    @ManyToMany(mappedBy = "itemList")
    private List<Category> categoryList = new ArrayList<>();
    */
    // e :: 별도의 연결 엔티티를 사용하지 않는 경우 :: //
}
