package com.ldl575.c9.exam.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
	private String userName;
	private String password;
	private String position;
	private String militaryRank;
	private String role;
	private Date lastest_update;
	private Date created_at;
}
