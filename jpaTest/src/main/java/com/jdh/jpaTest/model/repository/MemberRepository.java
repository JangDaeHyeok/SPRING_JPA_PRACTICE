package com.jdh.jpaTest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdh.jpaTest.model.entity.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByMemberIdx(Long memberIdx);
	Member findById(String id);
	Member findByName(String name);
}
