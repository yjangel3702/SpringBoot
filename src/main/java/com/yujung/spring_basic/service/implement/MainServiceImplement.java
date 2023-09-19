package com.yujung.spring_basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yujung.spring_basic.dto.request.PostUserRequestDto;
import com.yujung.spring_basic.dto.response.PostUserResponseDto;
import com.yujung.spring_basic.dto.response.ResponseDto;
import com.yujung.spring_basic.entity.UserEntity;
import com.yujung.spring_basic.repository.UserRepository;
import com.yujung.spring_basic.service.MainService;

import lombok.RequiredArgsConstructor;

// description: @Component - 해당 클래스를 Java bean으로 등록하며 Spring이 인스턴스 생성을 알아서 할 수 있도록 하는 어노테이션 //
// description: @Service - @Component와 동일한 작업을 수행하지만 가독성을 위해 Service라는 이름을 가짐 //
@Service
@RequiredArgsConstructor
public class MainServiceImplement implements MainService {

  private final UserRepository userRepository;

  @Override
  public String getMethod() {
    return "This method is GET method.";
  }

  @Override
  public ResponseEntity<? super PostUserResponseDto> postUser(PostUserRequestDto dto) {

    // INSERT INTO user (email, password, nickname, tell_number, address, address_detail)
    // VALUES(dto.getEmail(), dto.getPassword(), ...);

    try {
    // description: Create 작업 순서 (INSERT) //
    // description: 1. Entity 인스턴스 생성 //
    UserEntity userEntity = new UserEntity(dto);
    // description: 2. repository의 save 메서드 사용 //
    userRepository.save(userEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("DBE", "Database Error"));
    }
    

    return ResponseEntity.status(HttpStatus.OK).body(new PostUserResponseDto("SU", "Success"));

  }
  

}
