package kr.shjo.seminar.restapi.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class MemberSaveParamModel {
	@NotEmpty
	private String id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String email;
	
	@NotNull
	private Integer age;
}
