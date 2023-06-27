### 회원 웹기능-홈 화면 추가

- 요청이 들어오면 요청에 해당하는 Controller를 찾아서 호출한다.
- 만약 존재하지 않는 URL이라면, 정적 리소스(static)를 반환한다.

### 순수 JDBC
- JDBC API를 직접 사용하는 것은 너무나도 비효율적이다.
- 개방-폐쇄 원칙(OCP, Open-Closed Principle) : 확장에는 열려있고, 수정, 변경에는 닫혀있다.
- Spring DI(Dependency Injection)을 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있다.
- 스프링의 DI를 사용하면 **기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있다.**

### Spring 통합 테스트
- @SpringBootTest : 스프링 컨테이너와 테스트를 함께 실행한다.
- @Transactional : 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후 항상 롤백한다.
- @Commit : 테스트 완료 후에도 트랜잭션을 커밋한다.
- 좋은 테스트는 단위 테스트일 확률이 높다

### AOP가 필요한 상황
- 모든 메소드의 호출 시간을 측정하고 싶다면?
- 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)
- 회원 가입 시간, 회원 조회 시간을 측정하고 싶다면?

### AOP 적용
- @Controller, @Service, @Repository 빈을 등록할 때 공통 관심 사항을 적용할 수 있도록 해주는 기능이다.
- AOP와 같은 기능은 SpringConfig에서 설정해주는 것이 좋다.(@ComponentScan 보다)
