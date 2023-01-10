## Bean이란 무엇일까?

Bean이란 스프링 IoC 컨테이너에 의해 관리되고, 애플리케이션의 핵심을 이루는 객체를 의미한다. 스프링 IoC 컨테이너에서 관리된다는 점을 빼면 그냥 자바 객체 이다. 기본적으로 Singleton으로 만들어진다.

<br>

## 🤔 Singleton은 뭔데?

클래스의 인스턴스가 딱 1개만 생성되는것을 보장하는 디자인 패턴이다.
예를 들어 우리가 MemberService를 bean으로 컨테이너에 등록을 하는데 사용할때 마다 새로 생성한다고 가정을 하면 Singleton으로 관리하는것보다 월등히 서버의 성능이 저하할 것이다. 


![image](https://user-images.githubusercontent.com/82089918/211445270-fdf24252-8ad7-4912-b089-83337f325aca.png)

MemberService를 사용할때마다 동일한 객체를 컨테이너가 반환해주는것을 알 수 있다.

<br>

## 🚨 싱글톤 패턴의 주의점

- 하나의 인스턴스를 생성해서 공유하는 형식이므로 객체의 상태를 유지하게 설계하면 안된다.

- 특정 클라이언트에 의존적이거나 값을 변경할 수 있는 필드가 있으면 안된다.

- 가급적 읽기만 가능해야한다.

- 필드 대신 공유되지 않은 지역변구, 파라미터, ThreadLocal을 쓰자.

<br>

## 🦖 Bean을 등록하는 방법은?

    IoC 컨테이너에 빈을 등록하는 방법은 크게 두가지가 있다.

첫번째는 @Component 어노테이션을 사용하는 방법이 있다.

Bean을 등록하기 위해서는 **@Component** 어노테이션을 사용한다. 
직접 **@Component**를 작성해도 되고, stereotype인 @Controller, @Service, @Repository 어노테이션도 까보면 @Component를 내장하고 있어 
Bean으로 인식한다.

**@Component** 어노테이션을 IoC 컨테이너에 등록하기 위해서는 ~~Application에 자동으로 붙어있는 **@SpingbootApplication** 어노테이션을 까보면 @ComponentScan이라는 어노테이션이 component scan을 해줘 IoC 컨테이너에 등록해준다.

<img width="912" alt="image" src="https://user-images.githubusercontent.com/82089918/211448698-5d6dedaf-269f-4299-ae4a-5fb394ddf824.png">

<br>

> 💡 component scan 대상이 ~~Application 클래스보다 상위에 있다면 component scan을 못한다.

<br>

두번째로는 빈 설정 파일에 등록하는 방법이 있다.

해당 방법은 @Configuration과 @Bean 어노테이션을 사용한다.
<br>
@Configuration 어노테이션은 해당 파일에 빈을 등록할것이니 scan해라! 라는 어노테이션이다. @Configuration 어노테이션이 붙은 파일 내에서 @Bean 어노테이션을 사용해서 Bean을 직접 등록하는데, @Bean을 사용해 수동으로 등록할때는 해당 메서드 이름이 Bean이름으로 결정된다.

