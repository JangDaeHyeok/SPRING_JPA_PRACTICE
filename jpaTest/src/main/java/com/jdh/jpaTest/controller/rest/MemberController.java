package com.jdh.jpaTest.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdh.jpaTest.model.api.ApiResponseCode;
import com.jdh.jpaTest.model.api.ApiResponseDTO;
import com.jdh.jpaTest.model.api.ApiResponseResult;
import com.jdh.jpaTest.model.api.ApiResultType;
import com.jdh.jpaTest.model.entity.Member;
import com.jdh.jpaTest.model.repository.MemberRepository;

@RestController
public class MemberController {
	@Autowired MemberRepository memberRepository;
	
	@GetMapping(value="member")
	public Map<String, Object> memberGet(@RequestParam Map<String, Object> input) throws Exception{
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		/* 단건 조회 시 사용
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		*/
		
		List<Member> memberList = memberRepository.findAll();
		dataMap.put(ApiResultType.DATA_LIST, memberList);
		
		return new ApiResponseDTO(ApiResponseResult.SUCEESS, ApiResponseCode.OK, dataMap).getReturnMap();
	}
}
