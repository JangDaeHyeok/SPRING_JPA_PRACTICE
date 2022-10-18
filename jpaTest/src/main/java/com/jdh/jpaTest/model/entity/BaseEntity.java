package com.jdh.jpaTest.model.entity;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@MappedSuperclass
public class BaseEntity {
    @CreationTimestamp
    @Column(name = "reg_dt")
    private Date regDt = null;

    @UpdateTimestamp
    @Column(name = "mod_dt", insertable = false)
    private Date modDt = null;
}
