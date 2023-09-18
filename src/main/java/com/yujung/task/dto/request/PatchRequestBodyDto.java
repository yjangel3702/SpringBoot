package com.yujung.task.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PatchRequestBodyDto {
  
  private String taskNumber;
  @NotNull
  @NotBlank
  private String taskName;
  @NotNull
  @NotBlank
  private String category;
  @NotNull
  @NotBlank
  private String contents;
  @NotNull
  @NotBlank
  private String date;
  @NotNull
  @NotBlank
  private String time;
 
}
