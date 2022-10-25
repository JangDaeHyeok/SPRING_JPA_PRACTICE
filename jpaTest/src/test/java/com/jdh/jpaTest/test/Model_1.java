package com.jdh.jpaTest.test;

import java.util.List;
import java.util.Optional;

import com.jdh.jpaTest.model.entity.Address;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdh.jpaTest.model.entity.Member;
import com.jdh.jpaTest.model.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class Model_1 {
	@Autowired MemberRepository memberRepository;
	
	@Test
	@Order(1)
	@DisplayName("Member Insert")
	void save() {
		Member member = new Member();
		member.setName("장대혁");
		Address address = Address.builder()
				.city("춘천")
				.street("장학리")
				.zipcode("01010")
				.build();
		member.setAddress(address);
		/*
		member.setCity("춘천");
		member.setStreet("장학리");
		member.setZipcode("01010");
		*/

		/*
		 * JpaRepository interface의 save 구현체를 보면
		 * 새로운 Entity인 경우 persist, 아닌 경우 merge 한다.
		 * merge는 준영속 상태의 Entity를 새로운 영속 상태로 변경(반환)한다.
		 */
		memberRepository.save(member);
		
		member = new Member();
		member.setName("최미애");
		Address address2 = Address.builder()
				.city("춘천")
				.street("거두리")
				.zipcode("23232")
				.build();
		member.setAddress(address2);
		/*
		member.setCity("춘천");
		member.setStreet("거두리");
		member.setZipcode("23232");
		*/
		memberRepository.save(member);
	}
	
	@Test
	@Order(2)
	@DisplayName("Member Select")
	void select() {
		List<Member> memberList = memberRepository.findAll();
		for(Member member : memberList) log.info("[Model_1] findAll => id : {}, name : {}, regDt : {}, modDt : {}", member.getId(), member.getName(), member.getRegDt(), member.getModDt());
	}

	@Test
	@Order(3)
	@DisplayName("Member Update")
	void update() {
		Optional<Member> member = memberRepository.findById(9L);

		member.ifPresent(selectMember -> {
			Address address = Address.builder()
					.city(selectMember.getAddress().getCity())
					.street("소양로")
					.zipcode("56565")
					.build();
			selectMember.setAddress(address);
			memberRepository.save(selectMember);
			log.info("[Model_1] find => id : {}, name : {}, street : {}, zip : {}", selectMember.getId(), selectMember.getName(), selectMember.getAddress().getStreet(), selectMember.getAddress().getZipcode());
		});
	}

	/*
	@Test
	@Order(4)
	@DisplayName("Member remove")
	void remove() {
		Optional<Member> member = memberRepository.findById(1L);
		member.ifPresent(selectMember -> {
			memberRepository.delete(selectMember);
		});

		Optional<Member> member2 = memberRepository.findById(2L);
		member2.ifPresent(selectMember -> {
			memberRepository.delete(selectMember);
		});
	}
	*/
}
