package com.jdh.jpaTest.model.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Parent {
    @EmbeddedId
    private ParentId id;
    private String name;

    @Builder
    public Parent(ParentId id, String name) {
        this.id = id;
        this.name = name;
    }
}
