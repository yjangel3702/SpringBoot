package com.yujung.spring_basic.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yujung.spring_basic.dto.request.PatchNicknameRequestDto;
import com.yujung.spring_basic.dto.request.PatchValidationDto;
import com.yujung.spring_basic.dto.request.PostRequestBodyDto;
import com.yujung.spring_basic.dto.request.PostUserRequestDto;
import com.yujung.spring_basic.dto.response.DeleteUserResponseDto;
import com.yujung.spring_basic.dto.response.PatchNicknameResponseDto;
import com.yujung.spring_basic.dto.response.PostUserResponseDto;
import com.yujung.spring_basic.dto.response.TmpResponseDto;
import com.yujung.spring_basic.service.MainService;
import lombok.RequiredArgsConstructor;

// description: Controller - 레이어드 아키텍처 상의 프레젠테이션 영역 //
// description: 클라이언트로부터 요청(입력)을 받고 서비스 결과를 응답(출력)하는 영역 //

// description: @RestController - REST API 형식 Controller를 만들고자 할 때 사용하는 어노테이션 //
// description: Response Body의 타입이 JSON 형태의 데이터를 반환 //
@RestController
// description: @RequestMapping - Request의 URL 패턴에 따라 클래스 및 메소드를 결정하는 어노테이션 //
@RequestMapping("/") // http://localhost:4000/**
// @RequestMapping("/main") http://localhost:4000/main/**
@RequiredArgsConstructor // final 붙은거만 생성자가 생김
public class MainController {

  // description: @Autowired - Java bean으로 등록되어 있는 클래스에 대해서 제어의 역전을 통해 의존성을 주입하는 어노테이션 //
  // @Autowired
  // description: IoC를 통해서 DI하는 방법 //
  // description: 1. 멤버변수를 사용한 DI //
  // description: 2. setter 메서드를 사용한 DI //
  // description: 3. 생성자를 사용한 DI //

  // description: Spring Framework 공식 문서 상에서 생성자를 사용한 DI를 권장 //
  // description: 생성자를 사용한 DI에서는 @Autowired를 사용하지 않아도 됨 //

  // description: 아래 방법은 생성자를 사용한 IoC를 통한 DI이며 final로 지정하여 필수 멤버 변수로 지정함 //
  // description: lombok 라이브러리의 @RequiredArgsConstructor를 사용하여 필수 멤버 변수의 생성자를 만듦 //
  private final MainService mainService;

  // http://localhost:4000/hello GET
  @RequestMapping(value = "hello", method = {RequestMethod.POST})
  public String hello() {
    return "Hello Spring framework!!";
  }

  // description: @RequestMapping 중 GET Method에 한정하여 인식 //
  // description: 데이터를 얻기 위한 요청 //
  // description: 데이터 입력시 URL로 입력. //
  @GetMapping("")
  public String getMethod() {
    return mainService.getMethod();
  }

  // description: @RequestMapping 중 POST Method에 한정하여 인식 //
  // description: 데이터를 생성하기 위한 요청 //
  // description: 데이터 입력시 Body로 입력 //
  @PostMapping("")
  public String postMethod() {
    return "This method is Post Method";
  }

  // description: @RequestMapping 중 PUT Method에 한정하여 인식 //
  // description: 데이터를 수정하기 위한 요청 (전체를 수정) //
  // description: 데이터 입력시 Body로 입력 //
  @PutMapping("")
  public String putMethod() {
    return "This method is Put Method!";
  }

  // description: @RequestMapping 중 PATCH Method에 한정하여 인식 //
  // description: 데이터를 수정하기 위한 요청 (일부를 수정) //
  // description: 데이터 입력시 Body로 입력 //
  @PatchMapping("")
  public String patchMethod() {
    return "This method is Patch Method!";
  }

  // description: @RequestMapping 중 DELETE Method에 한정하여 인식 //
  // description: 데이터를 삭제하기 위한 요청 //
  // description: 데이터 입력시 URL로 입력 //
  @DeleteMapping("")
  public String deleteMethod() {
    return "This method is Delete Method";
  }

  // description: @PathVariable - Path 자체를 변수의 값으로 인식 //
  // description: {변수명}으로 표현 -> @PathVariable("변수명")으로 받음 //
  @GetMapping("path-variable/{variable}")
  public String getPathVariable(
    @PathVariable("variable") String varialbe
  ) {
      return "Parameter value : " + varialbe;
  }

  // description: @RequestParam - Query Parameter로 Key와 Value를 받아옴 //
  // description: Query Parameter - ?name1=value1&name2=value... //
  // description: @RequestParam("name1") -> name1에 대한 value1를 받음 //
  @GetMapping("parameter")
  public String getParameter(
    @RequestParam("name") String name,
    @RequestParam("age") Integer age
  ) {
      return "name: " + name + ", age: " + age;
  }

  // description: @RequestBody - Request의 Body에 포함된 데이터를 받아옴 //
  // description: 문자열 혹은 객체로 받을 수 있음 //
  @PostMapping("request-body")
  public String postRequestBody(
    // @RequestBody String requestBody
    @RequestBody PostRequestBodyDto requestBody
  ) {
      return "Request의 Body는 " + requestBody.getName() + " " + requestBody.getAge() + " 입니다.";
  }

  @PatchMapping("validation")
  public String validation(
    // description: DTO에 작성된 유효성 검사를 적용하려한다면 @Valid를 매개변수 자리에 추가해줘야 함 //
    @RequestBody @Valid PatchValidationDto requestBody
  ) {
    return requestBody.getArg1();
  }

  @GetMapping("response-entity")
  public ResponseEntity<TmpResponseDto> getResponseEntity() {
    TmpResponseDto responseBody = new TmpResponseDto("안녕", 10);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
  }

  @PostMapping("user")
  public ResponseEntity<? super PostUserResponseDto> postUser(
    @RequestBody @Valid PostUserRequestDto requestBody
) {
    ResponseEntity<? super PostUserResponseDto> response = mainService.postUser(requestBody);
    return response;
  }

  @PatchMapping("nickname") // 요청(request)을 매개변수로, 응답(response)을 반환
  public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(
    @RequestBody @Valid PatchNicknameRequestDto requestBody
  ) {
    ResponseEntity<? super PatchNicknameResponseDto> response = mainService.patchNickname(requestBody);
    return response;
  }

  @DeleteMapping("user/{email}")
  public ResponseEntity<? super DeleteUserResponseDto> deleteUser(
    @PathVariable("email") String email
  ) {
    ResponseEntity<? super DeleteUserResponseDto> response = mainService.deleteUser(email);
    return response;
  }

}
