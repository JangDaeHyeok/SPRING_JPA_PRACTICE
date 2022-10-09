package com.jdh.jpaTest.Member;

import java.util.List;

import org.junit.jupiter.api.*;
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
	@DisplayName("Member Insert")
	void save() {
		Member member = new Member();
		member.setName("장대혁");
		member.setCity("춘천");
		member.setStreet("장학리");
		member.setZipcode("01010");
		/*
		 * JpaRepository interface의 save 구현체를 보면
		 * 새로운 Entity인 경우 persist, 아닌 경우 merge 한다.
		 * merge는 준영속 상태의 Entity를 새로운 영속 상태로 변경(반환)한다.
		 */
		memberRepository.save(member);
		
		member = new Member();
		member.setName("최미애");
		member.setCity("춘천");
		member.setStreet("거두리");
		member.setZipcode("23232");
		memberRepository.save(member);
	}
	
	@Test
	@Order(2)
	@DisplayName("Member Select")
	void select() {
		List<Member> memberList = memberRepository.findAll();
		for(Member member : memberList) log.info("[MemberTest] findAll => id : {}, name : {}", member.getId(), member.getName());
	}
}
