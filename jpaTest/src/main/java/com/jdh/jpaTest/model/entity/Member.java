package com.jdh.jpaTest.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long memberIdx;

	private String id;
	
	private String name;
}
