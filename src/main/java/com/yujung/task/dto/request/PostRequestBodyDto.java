package com.yujung.task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestBodyDto {
  private String taskName;
  private String category;
  private String contents;
  private String date;
  private String time;
  
}
