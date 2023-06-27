### SpringFramework의 등장
- EJB의 복잡함을 해결하기 위해 등장
- EJB는 기업용 분산환경에서 사용하기 위해 등장
- SpringFramework는 EJB의 복잡함을 해결하고, EJB의 장점을 살리기 위해 등장
- Rod Johnson이 EJB의 복잡함을 해결하기 위해 2002년에 출간한 책 "Expert One-on-One J2EE Development without EJB"에서 등장
- SpringFramework는 EJB를 사용하지 않고도 EJB의 장점을 살릴 수 있도록 해줌
- 기본적인 기능은 단순하지만 여러 기능을 조합하여 사용해야하기 때문에 설정이 복잡함
- Library 설정, Bean 설정, AOP 설정, Transaction 설정 등등 
- SpringFramework는 설정이 복잡하기 때문에 SpringBoot가 등장

### SpringBoot의 등장
- SpringFramework의 설정이 복잡하기 때문에 SpringBoot가 등장
- Boot란 개발자의 최소한의 개입으로 시작하고 완전히 동작 하는 것을 의미

#### SpringBoot의 핵심 기능 5가지
1. WAS(Web Application Server)에 대한 설정이 없어도 동작: 내장 tomcat
2. Library 설정이 없어도 동작: SpringBoot가 자동으로 설정
   - 손쉬운 빌드를 위한 Starter 종속성 제공
   - Spring과 3rd party library의 버전을 관리
3. Bean 설정이 없어도 동작: SpringBoot가 자동으로 설정
   - SpringBoot가 자동으로 Bean을 등록
4. 외부 설정 환경에 대한 설정이 없어도 동작: SpringBoot가 자동으로 설정
   - application.properties, application.yml 파일을 통해 설정
5. 프로덕션 준비 기능 제공
   - Actuator를 통해 모니터링, 관리 기능 제공

#### SpringBoot를 배워야 하는 이유
1. 편리하지만 너무 많은 것을 자동화
2. 최소한의 동작 원리는 알아야 함
3. 그래야 문제 해결 가능
4. 문제점 쉽게 파악 가능
5. 수 많은 편의 기능 제공
6. 개발시간 단축 가능
