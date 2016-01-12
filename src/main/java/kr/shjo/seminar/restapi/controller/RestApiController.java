package kr.shjo.seminar.restapi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.shjo.seminar.restapi.model.MemberModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RestApiController {
	
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public @ResponseBody List<MemberModel> getMemberList() throws Exception {
		log.info("########### getMemberList()");
		return null;
	}
	
	@RequestMapping(value = "/members/{memberId}", method = RequestMethod.GET)
	public @ResponseBody MemberModel getMember(
		@PathVariable long memberId) throws Exception {
		log.info("########### getMember()");
		log.info("########### memberId: {}", memberId);
		
		MemberModel memberModel = new MemberModel(memberId, "shjo72", "조수희", "shjo72@nexon.co.kr", 26);
		
		return memberModel;
	}
	
}
