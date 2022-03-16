package com.ldl575.c9.exam.dto.common;

import javax.swing.JFrame;

import com.ldl575.c9.exam.entity.UserEntity;

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
public class ComunicatedDto {

	private JFrame frame;
	private UserEntity userEntity;
}
