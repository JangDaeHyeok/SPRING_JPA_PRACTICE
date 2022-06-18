package com.jdh.jpaTest.Member;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdh.jpaTest.model.entity.Member;
import com.jdh.jpaTest.model.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class MemberTest {
	@Autowired MemberRepository memberRepository;
	
	@Test
	@Order(1)
	void save() {
		Member member = new Member();
		member.setId("jdh2541");
		member.setName("장대혁");
		memberRepository.save(member);
		
		member = new Member();
		member.setId("chlaldo1220");
		member.setName("최미애");
		memberRepository.save(member);
	}
	
	@Test
	@Order(2)
	void select() {
		List<Member> memberList = memberRepository.findAll();
		for(Member member : memberList) log.info("[MemberTest] findAll => id : {}, name : {}", member.getId(), member.getName());
	}
}
