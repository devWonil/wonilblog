package com.tencoding.wonilblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 같은 변수명 다른 데이터타입 = 제네릭
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

	private int status;
	private T data;
}
