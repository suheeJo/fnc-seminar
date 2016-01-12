package kr.shjo.seminar.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberModel {
	private Long idx;
	private String id;
	private String name;
	private String email;
	private Integer age;
}
