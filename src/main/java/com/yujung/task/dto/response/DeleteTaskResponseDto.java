package com.yujung.task.dto.response;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;

@Getter
@ResponseBody
public class DeleteTaskResponseDto extends ResponseDto {

  public DeleteTaskResponseDto(String code, String message) {
    super(code, message);
  }
  
}
