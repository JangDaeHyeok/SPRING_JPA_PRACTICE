package com.jdh.jpaTest.controller.view;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MemberViewController {
	@GetMapping(value="member/view")
	public ModelAndView memberGet(@RequestParam Map<String, Object> input) throws Exception {
		ModelAndView mv = new ModelAndView("member/member");
		return mv;
	}
}
