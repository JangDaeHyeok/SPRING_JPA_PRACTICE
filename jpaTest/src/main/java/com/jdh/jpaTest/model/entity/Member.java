package com.jdh.jpaTest.model.entity;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DynamicUpdate
public class Member extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	
	private String name;

	private String city;
	private String street;
	private String zipcode;

	@OneToMany(mappedBy = "member")
	private List<Orders> OrderList = new ArrayList<>();
}
