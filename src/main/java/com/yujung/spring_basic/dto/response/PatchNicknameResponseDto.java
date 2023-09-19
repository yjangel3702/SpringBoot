package com.yujung.spring_basic.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PatchNicknameResponseDto extends ResponseDto {
  
  public PatchNicknameResponseDto (String code, String message) {
    super(code, message);
  }
}
