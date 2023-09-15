package com.yujung.task.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yujung.task.dto.request.PostRequestBodyDto;

@RestController
@RequestMapping("/api/v1/task")
public class MainController {
  
  @GetMapping("{taskNumber}")
  public String getTask(
    @PathVariable("taskNumber") String taskNumber
  ) {
      return "일정은 " + taskNumber + "번 입니다.";
  }

  @PostMapping("")
  public String postRequestBody(
    @RequestBody PostRequestBodyDto requestBody
  ) {
      return "소개드릴 일정은 " + requestBody.getTaskName() + "이며, 카테고리는 " 
      + requestBody.getCategory() + "로 분류됩니다. 이 일정은 " 
      + requestBody.getContents() + " 등의 활동으로 구성되어 있습니다. 일정은 "
      + requestBody.getDate() + requestBody.getTime() + "에 시작됩니다!";
  }

  @PatchMapping("{taskNumber}")
  public String patchTask(
    @PathVariable("taskNumber") String taskNumber,
    @RequestBody PostRequestBodyDto requestBody
  ) {
      return "소개드릴 일정은 " + requestBody.getTaskName() + "이며, 카테고리는 " 
      + requestBody.getCategory() + "(으)로 분류됩니다. 이 일정은 " 
      + requestBody.getContents() + " 등의 활동으로 구성되어 있습니다. 일정은 "
      + requestBody.getDate() + requestBody.getTime() + "에 시작됩니다!";
    }

  @DeleteMapping("{taskNumber}")
  public String deleteTask(
    @PathVariable("taskNumber") String taskNumber
  ) {
    return taskNumber + "번 일정의 데이터를 삭제합니다.";
  }

}
