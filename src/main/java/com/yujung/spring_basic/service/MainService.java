package com.yujung.spring_basic.service;

import org.springframework.http.ResponseEntity;

import com.yujung.spring_basic.dto.request.PatchNicknameRequestDto;
import com.yujung.spring_basic.dto.request.PostUserRequestDto;
import com.yujung.spring_basic.dto.request.SignInRequestDto;
import com.yujung.spring_basic.dto.response.DeleteUserResponseDto;
import com.yujung.spring_basic.dto.response.PatchNicknameResponseDto;
import com.yujung.spring_basic.dto.response.PostUserResponseDto;
import com.yujung.spring_basic.dto.response.SignInResponseDto;

public interface MainService {
  
  String getMethod();
  ResponseEntity<? super PostUserResponseDto> postUser(PostUserRequestDto dto);
  ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto);
  ResponseEntity<? super DeleteUserResponseDto> deleteUser(String email);
  ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
  
}
