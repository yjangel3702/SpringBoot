package com.yujung.spring_basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;

// description: Entity - JPA를 사용할 때 데이터베이스의 테이블과 매핑되는 Java 객체 //

@Getter
@AllArgsConstructor
// description: @Entity - 해당 클래스를 JPA Entity로 사용하겠다고 지정하는 어노테이션 //
@Entity(name="user")
// description: @Table - 해당 Entity 클래스가 데이터베이스의 어떤 테이블과 매핑될 지를 명시하는 어노테이션 //
@Table(name="user")
public class UserEntity {
  // description: @Id - Entity 클래스에서 Primary Key 필드를 표시할 때 사용되는 어노테이션 //
  @Id
  private String email;
  private String password;
  private String nickname;
  private String tellNumber;
  private String addressDetail;
  private boolean agreedPersonal;
  private String profileImageUrl;

  // description: Entity 클래스의 필드와 데이터베이스 테이블의 컬럼을 명시적으로 매핑하는 어노테이션 //
  // @Column(name="profile_image_url")
  // private String prifile;
}
