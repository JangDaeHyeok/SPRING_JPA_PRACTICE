package com.jdh.jpaTest.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Category_item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
