package com.yujung.spring_basic.service;

import org.springframework.http.ResponseEntity;

public interface MainService {
  
  String getMethod();
  ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto);

}
