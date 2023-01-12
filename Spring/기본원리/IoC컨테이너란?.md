## IoC 컨테이너란?

객체를 생명주기를 책임지고 의존성을 관리해주는 컨테이너이다.

<br>

## 🤔 왜 사용하는데?

IoC 컨테이너를 사용하지 않는다면 개발자가 필요한 인스턴스가 있을때마다 생성을 할 것인데, IoC 컨테이너를 사용한다면 컨테이너에서 필요한 인스턴스를 가져다 쓸 수 있어 개발자는 비지니스 로직에 집중을 할 수 있다. 객체 생성 코드가 없으므로 TDD도 용이하다.

<br>

## 📣 Bean Factory와 Application Context

스프링 컨테이너는 두가지 종류가 있다고 한다. Bean Factory와 Bean Factory를 상속하는 Application Context이다.

#### 1. Bean Factory

![image](https://user-images.githubusercontent.com/82089918/211984964-2b0bc413-ab17-4521-89dd-6faade5101a8.png)

- 스프링 컨테이너의 최상위 인터페이스이다.
- 팩토리 디자인 패턴을 구현한것으로, Bean을 관리, 생성, 조회의 역할을 한다.
- getBean()을 제공한다.
- 컨테이너가 구동될때 Bean을 생성하는게 아닌 클라이언트가 요청에 의해서 사용시점에 Bean이 생성되는 지연로딩(Lazy Loading) 방식을 사용한다.

#### 2. Application Context

![image](https://user-images.githubusercontent.com/82089918/211984616-1adfafa4-57dc-4ebb-9847-571c4b6160c9.png)

- Bean Factory 기능을 모두 상속받아서 제공한다.
- Bean Factory와 달리 Application Context는 사전로딩(pre-loading) 방식이여서 컨테이너가 구동될 때 Bean이 생성된다.
- **MessageSource** 메세지 소스를 활용한 국제화 기능 -> 한국에서 들어오면 한국어로, 영어권이로 들어오면 영어로
- **EnvironmentCapable** 환경변수 -> 로컬, 개발, 운영 등을 구분해서 처리
- **ApplicationEventPublisher** 애플리케이션 이벤트 -> 이벤트를 발행하고 구독하는 모델을 편리하게 지원
- **ResourceLoader** 편리한 리소스 조회 -> 파일, 클래스 패스, 외부 등에서 리소스를 편리하게 조회
- Bean Factory를 직접 사용할 일은 거의 없고, 부가 기능이 추가된 Application Context를 사용한다고 한다.
