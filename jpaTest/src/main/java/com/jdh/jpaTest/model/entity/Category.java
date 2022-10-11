package com.jdh.jpaTest.model.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DynamicUpdate
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Category_item> categoryItemList = new ArrayList<>();

    // s :: 카테고리 계층 구조를 위한 필드 :: //
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child;
    // e :: 카테고리 계층 구조를 위한 필드 :: //

    // 연관관계 메소드
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

    // s :: 별도의 연결 엔티티를 사용하지 않는 경우 :: //
    /*
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM"
                , joinColumns = @JoinColumn(name = "category_id")
                , inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> itemList = new ArrayList<>();
    */
    // e :: 별도의 연결 엔티티를 사용하지 않는 경우 :: //
}
