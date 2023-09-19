package com.yujung.spring_basic.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatchValidationDto {
  // description: Validation - 유효성 검사를 도와주는 라이브러리 사용 //
  // description: build.gradle의 dependencies에 implementation 'org.springframework.boot:spring-boot-starter-validation'을 추가해야함 //
  
  // description: @NotNull - 해당 멤버 변수를 필수값으로 지정함 (null이 올 수 없도록 함) //
  // @NotNull
  // description: @NotEmpty - 해당 멤버 변수가 null 혹은 빈문자열을 가질 수 없도록 함 //
  // @NotEmpty
  // description: @NotBlank - 해당 멤버 변수가 null 혹은 빈문자열 혹은 공백으로만 이루어진 문자열을 가질 수 없도록 함 //
  @NotBlank
  // description: @Size - 문자열과 컬렉션타입(리스트, 세트 등)의 길이의 제한을 줄 수 있도록 함 //
  @Size(min=1, max=5)
  // description: @Length - 문자열의 길이 제한을 줄 수 있도록 함 //
  @Length(min=1, max=5)
  private String arg1;
  @NotNull
  // description: @Range - 숫자의 범위를 지정할 수 있도록 함 //
  @Range(min=1, max=5)
  private Integer arg2;
  // description: @Email - 문자열에 이메일 형식만 올 수 있도록 함 //
  @Email
  private String arg3;
  // description: @URL - 문자열에 URL 형식만 올 수 있도록 함 //
  @URL
  private String arg4;
}
