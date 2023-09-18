package com.yujung.spring_basic.service.implement;

import org.springframework.stereotype.Service;

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
  

}
