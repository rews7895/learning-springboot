# 참고사항
1. spring actuator: 애플리케이션의 모니터링 및 관리 도구

### 스프링부트는 내장 WAS가 존재한다.
1. 톰캣
2. 제티
3. 언더토우

### 제어의 역전 (IoC, Inversion of Control)
- 제어의 역전은 다른 객체를 직접 생성하거나 제어하는 것이 아니라 외부에서 관리하는 객체를 가져와 사용하는 것
- 객체의 생성과 관리를 개발자가 하는 것이 아니라 프레임워크가 대신하는 것

### 의존성 주입 (DI, Dependency Injection)
- 외부에서 객체를 주입받아 사용하는 것
- 제어의 역전을 구현하기 위해 DI를 사용한다.

### 스프링 컨테이너
- 빈을 생성하고 관리한다.
- 즉, 빈이 생성되고 소멸되기까지의 생명주기를 이 스프링 컨테이너가 관리하며 @Autowired 같은 어노테이션을 사용해 빈을 주입받을 수 있게 DI를 지원하기도 한다.

### 빈
- 스피링 컨테이너가 생성하고 관리하는 객체
- 스프링은 빈을 스프링 컨테이너에 등록하기 위해 XML 파일 설정, 어노테이션 추가등의 여러가지 방법을 제공한다.

### 관점 지향 프로그래밍 (AOP, Aspect Oriented Programming)
- 프로그래밍에 대한 관심을 핵심 관점, 부가 관점으로 나누어서 관심 기준으로 모듈화하는 것을 의미

### 이식 가능한 서비스 추상화 (PSA, Portable Service Abstraction)
- 스프링에서 제공하는 다양한 기술들을 추상화해 개발자가 쉽게 사용하는 인터페이스
- 어느 기술을 사용하던 일관된 방식으로 처리하도록 하는 것

### 스프링 부트 스타터
- spring-boot-stater-{작업유형}이라는 명명 규칙 존재
- spring-boot-stater-web: Spring MVC를 사용해서 RESTful 웹 서비스를 개발할 때 필요한 의존성 모음
- spring-boot-stater-test: 스프링 애플리케이션을 테스트하기 위해 필요한 의존성 모음
- spring-boot-stater-validation: 유효성 검사를 위해 필요한 의존성 모음
- spring-boot-actuator: 모니터링을 위해 애플리케이션에서 제공하는 다양한 정보를 제공하기 쉽게 하는 의존성 모음
- spring-boot-stater-data-jpa: ORM을 사용하기 위한 인터페이스의 모음인 JPA를 더 쉽게 사용하기 위한 의존성 모음

### 어노테이션
- 자바 소스 코드에 추가하는 표식으로, 보통 @ 기호를 앞에 붙여서 사용하며, JDK 1.5 버전부터 사용할 수 있다.
- 어노테이션은 다양한 목적으로 사용하지만, 메타 데이터(데이터에 대한 설명을 담고 있는 데이터)의 비중이 가장 크다.

### 자주 볼 수 있는 어노테이션 정리
- @SpringBootApplication: 스프링 부트 사용에 필요한 기본 설정을 해준다.
- @SpringBootConfiguration: 스프링 부트 관련 설정을 나타내는 어노테이션이며 스프링의 @Configuration을 상속해서 만듬.
- @ComponentScan: 사용자가 등록한 빈을 읽고 등록하는 어노테이션
- @EnableAutoConfiguration: 자동 구성을 활성화하는 어노테이션이며, 스프링 부트 서버가 실행될 때 스프링 부트의 메타파일을 읽고 정의된 설정들을 자동으로 구성하는 역할을 수행
- @Configuration: 설정 파일 등록
- @Repository: ORM 매핑
- @Controller, @RestController: 라우터
- @Service: 비즈니스 로직
- @SpringBootConfig: 스프링 부트 관련 설정
- @Component: 해당 어노테이션은 빈으로 등록되며, @Controller, @RestController, @Configuration, @Repository, @Service 모두 @Component 어노테이션을 가지고 있으며, 상황에 따라 알맞은 어노테이션을 사용해야 한다.