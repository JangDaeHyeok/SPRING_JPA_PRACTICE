package com.jdh.jpaTest.model.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {
    private Date regDt;
    private Date modDt;
}
