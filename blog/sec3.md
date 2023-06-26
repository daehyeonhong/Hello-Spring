### 일반적인 WebApplication 계층 구조

- Controller: 사용자의 요청을 받아서 처리하는 역할
- Service: 비즈니스 로직을 처리하는 역할
- Repository: DB에 접근하는 역할
- Domain: 비즈니스 도메인 객체

### 테스트 케이스란??

- 테스트 케이스는 테스트를 수행하기 위한 조건, 테스트의 진행 순서, 기대 결과 등을 기술한 문서
- 보통 main() 메소드를 통해 테스트를 수행하거나, 외부 애플리케이션을 통해 수행하는 경우 테스트 수행 시간이 오래 걸리고, 반복 수행하기 어렵다는 단점이 있다.
- 또한 여러 테스트 케이스를 한 번에 수행하기 어렵다는 단점도 있다.
- 이러한 단점을 보완하기 위해 JUnit이라는 프레임워크를 사용한다.

#### JUnit

- JUnit은 자바에서 단위 테스트를 수행할 수 있도록 도와주는 프레임워크
- JUnit은 테스트를 수행하는 데 필요한 다양한 기능을 제공한다.
- Test에 성공하면 초록색, 실패하면 빨간색으로 표시된다.
- assertj 라이브러리를 사용하면 테스트 코드를 더 편하게 작성할 수 있다.
- Test 코드는 수행순서가 보장되지 않는다.
- 따라서 테스트 간의 의존성이 존재하면 안된다.
- 테스트를 수행할 때마다 테스트 순서가 바뀌어도 테스트가 정상적으로 수행되어야 한다.
- 테스트가 종료되면 테스트에 사용된 모든 데이터는 롤백된다.

### 테스트

- 테스트 메소드 명은 한글로 작성 가능

### 스프링 빈과 의존관계

- Spring Container는 @Controller, @Service, @Repository, @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.
- 스프링 빈으로 등록된 클래스들은 스프링 컨테이너에서 관리되며, 스프링 컨테이너가 종료될 때까지 유지된다.

#### Spring Bean 등록 방법

1. Component Scan 과 AutoWired

- Spring을 사용하면 Component로 등록하여 사용하는게 유리
- ComponentScan 범위: @SpringBootApplication이 있는 패키지부터 하위 패키지까지

2. Java 코드로 직접 스프링 빈 등록하기

- 과거에는 xml로 직접 등록했지만, 요즘은 잘 사용하지 않는다.
- DI(Dependency Injection)을 사용하는 3가지 방법
    - 생성자 주입
    ```:java
    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }
    ```
    - 필드 주입
    ```:java
    @Autowired private MemberService memberService;
    ```
    - Setter 주입
    ```:java
    @Autowired
    public void setMemberService(final MemberService memberService) {
        this.memberService = memberService;
    }
    ```
    1. setter 주입은 잘 사용하지 않는다.
    2. public으로 열려있어야 하고, 누군가가 memberService를 변경할 수 있다.
    3. 의존 관계가 실행 중에 동적으로 변하는 경우는 거의 없으므로, 대부분 생성자 주입을 사용한다.
    4. Component Scan을 사용하면 여러 코드를 수정해야 하지만, Java 코드로 직접 스프링 빈을 등록하면 스프링 빈의 이름을 직접 부여할 수 있다.
