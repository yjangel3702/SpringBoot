package com.yujung.task.dto.response;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;

@Getter
@ResponseBody
public class GetTaskResponseDto extends ResponseDto{

  public GetTaskResponseDto(String code, String message) {
    super(code, message);
  }

  private String taskName;
  private String category;
  private String contents;
  private String date;
  private String time;
  
}
