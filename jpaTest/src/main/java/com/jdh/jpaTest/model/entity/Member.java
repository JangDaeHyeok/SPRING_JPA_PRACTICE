package com.jdh.jpaTest.model.entity;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	
	private String name;

	private String city;
	private String street;
	private String zipcode;
}
