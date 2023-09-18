package com.yujung.task.dto.response;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;

@Getter
@ResponseBody
public class PostTaskResponseDto extends ResponseDto {

  public PostTaskResponseDto(String code, String message) {
    super(code, message);
  }
  
}
