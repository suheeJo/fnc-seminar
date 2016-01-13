package kr.shjo.seminar.restapi.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import kr.shjo.seminar.restapi.model.MemberModel;
import kr.shjo.seminar.restapi.model.MemberSaveParamModel;
import lombok.extern.slf4j.Slf4j;

@Api(value="Rest API 세미나 테스트")
@Slf4j
@Controller
public class RestApiController {
	
	public final String SUCCESS = "SUCCESS";
	
	/**
	* 멤버 목록을 반환한다.
	* 
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public @ResponseBody List<MemberModel> getMemberList() throws Exception {
		log.debug("########### getMemberList()");
		return Arrays.asList(new MemberModel(1l, "shjo72", "조수희", "shjo72@nexon.co.kr", 26), new MemberModel(2l, "daphne", "최다희", "daphne@nexon.co.kr", 20));
	}
	
	/**
	* 멤버 정보를 저장한다.
	* 
	* @param memberSaveParamModel
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "/members", method = RequestMethod.POST)
	public @ResponseBody String insertMember(
		@RequestBody @Valid MemberSaveParamModel memberSaveParamModel) throws Exception {
		log.debug("########### insertMember()");
		log.debug("########### memberSaveParamModel: {}", memberSaveParamModel);
		
		return SUCCESS;
	}
	
	/**
	* 멤버 목록을 삭제한다.
	* 
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "/members", method = RequestMethod.DELETE)
	public @ResponseBody String deleteMemberList() throws Exception {
		log.debug("########### deleteMember()");
		
		return SUCCESS;
	}
	
	/**
	* memberId에 해당하는 정보를 반환한다.
	* 
	* @param memberId
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "/members/{memberId}", method = RequestMethod.GET)
	public @ResponseBody MemberModel getMember(
		@PathVariable long memberId) throws Exception {
		log.debug("########### getMember()");
		log.debug("########### memberId: {}", memberId);
		
		MemberModel memberModel = new MemberModel(memberId, "shjo72", "조수희", "shjo72@nexon.co.kr", 26);
		
		return memberModel;
	}
	
	/**
	* memberId에 해당하는 정보를 수정한다.
	* 
	* @param memberId
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "/members/{memberId}", method = RequestMethod.PUT)
	public @ResponseBody String updateMember(
		@PathVariable long memberId
		, @RequestBody @Valid MemberSaveParamModel memberSaveParamModel) throws Exception {
		log.debug("########### updateMember()");
		log.debug("########### memberId: {}", memberId);
		log.debug("########### memberSaveParamModel: {}", memberSaveParamModel);
		
		return SUCCESS;
	}
	
	@RequestMapping(value = "/members/{memberId}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteMember(
		@PathVariable long memberId) throws Exception {
		log.debug("########### deleteMember()");
		log.debug("########### memberId: {}", memberId);
		
		return SUCCESS;
	}
	
}
