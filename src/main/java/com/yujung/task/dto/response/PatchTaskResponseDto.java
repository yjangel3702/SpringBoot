package com.yujung.task.dto.response;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;

@Getter
@ResponseBody
public class PatchTaskResponseDto extends ResponseDto{

  public PatchTaskResponseDto(String code, String message) {
    super(code, message);
  }
  
}
