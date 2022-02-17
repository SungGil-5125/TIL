# JWT란?

JSON Web Token의 약자로, 각 객체 사이에서 속성 정보(claim)을 JSON 데이터 구조로 표현하고 암호화를 통해 정보를 전달하는 TOKEN의 대표이다.

    [특징]
    - 가볍고 자가 수용적(self-contained)
    - HTTP header / URL 파라미터를 이용해 전달 가능
    - 다양한 프로그램 언어에서 사용가능

![jwt](https://user-images.githubusercontent.com/82089918/154481559-ea6fcddf-625f-4728-8621-78fa75b8e8f9.png)

- HEADER(헤더)
   - typ : 토큰의 타입을 지정(JWT)
   - alg : 해싱 알고리즘 지정(보통 HMAC SHA256 / RSA 사용)

```javascript
{
  "typ": "JWT",
  "alg": "HS256"
}
```
---
- PAYLOAD(내용) : 사용되는 정보의 한조각을 클레임(claim)이라고 한다.
  
1) 등록된(registerd) 클레임 : 토큰에 대한 정보를 담기위해 정해진 클레임들

```javascript
//모든 클레임은 선택적으로 사용
iss : 토큰 발행자 (issuer)
sub : 토큰 제목 (subject)
aud : 토큰 대상자 (audience)
exp : 토큰 만료시간 (expiration)
nbf : not before을 의미 / 토큰의 활성 날짜
```

2) 공개(public) 클레임 : 충돌이 방지된 collision-resistant이름을 가져야함 (url을 많이 사용한다)
   
```javascript
{
	"https://neity16.com/auth/is_admin": true
}
```
3) 비공개(private) 클레임 : 클라이언트와 서버간 합의하에 사용되는 이름들 (데이터)
```c
{
"idx": 3,
"id": "neity16",
"age": 25,
}
```
---
- VERIFY SIGNATURE(서명) <br>
  : header + payload 정보를 비밀키로 해쉬를 하여 생성<br>
  (즉, payload가 바뀌어도 이 값에 영향을 주기 때문에 보안성이 높아진다).



## 작동원리

    1) 클라이언트가 로그인 요청을 한다.
    2) 서버에서 로그인 정보를 검증한다.
    3) 검증이 완료되면 서버는 클라이언트에게 signed 토큰을 발행한다.
    4) 클라이언트는 토큰을 저장해두고 서버에 요청할 때마다 토큰을 함께 전달한다.
    5) 서버는 토큰을 검증하고 응답한다.