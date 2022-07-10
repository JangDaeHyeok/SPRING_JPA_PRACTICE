package com.jdh.jpaTest.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

		if(input.containsKey("idx")) {
			dataMap.put(ApiResultType.DATA_ONE, memberRepository.findByMemberIdx(Long.parseLong(input.get("idx").toString())));
		}else if(input.containsKey("id")) {
			dataMap.put(ApiResultType.DATA_ONE, memberRepository.findById(input.get("id").toString()));
		}else if(input.containsKey("name")) {
			dataMap.put(ApiResultType.DATA_ONE, memberRepository.findByName(input.get("name").toString()));
		}else {
			List<Member> memberList = memberRepository.findAll();
			dataMap.put(ApiResultType.DATA_LIST, memberList);
		}

		return new ApiResponseDTO(ApiResponseResult.SUCEESS, ApiResponseCode.OK, dataMap).getReturnMap();
	}

	@PostMapping(value="member", produces = "application/json; charset=utf-8")
	public Map<String, Object> memberAdd(@RequestBody Member member) throws Exception{
		Map<String, Object> dataMap = new HashMap<String, Object>();

		Member createMember = memberRepository.save(member);
		dataMap.put(ApiResultType.DATA_ONE, createMember);

		return new ApiResponseDTO(ApiResponseResult.SUCEESS, ApiResponseCode.OK, dataMap).getReturnMap();
	}

	// TODO 수정 기능 개발

	@DeleteMapping(value="member")
	public Map<String, Object> memberDel(@RequestBody Member member) throws Exception{
		memberRepository.deleteById(member.getMemberIdx());

		return new ApiResponseDTO(ApiResponseResult.SUCEESS, ApiResponseCode.OK).getReturnMap();
	}
}
