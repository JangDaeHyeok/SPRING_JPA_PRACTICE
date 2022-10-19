package com.jdh.jpaTest.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentId implements Serializable {
    @Column(name = "parent_id1")
    private String id1;
    @Column(name = "parent_id2")
    private String id2;

    @Builder
    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
}
