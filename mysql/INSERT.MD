# INSERT

mysql에서는 INSERT INTO 문을 사용하여 새로운 레코드를 추가할 수 있다.

---
## 테이블 레코드 추가
INSERT INTO 문과 VALUE절을 사용하여 해당 테이블에 새로운 레코드를 추가할 수 있다.

    1. INSERT INTO 테이블이름(필드이름1, 필드이름2, 필드이름3...)
       VALUE (데이터값1, 데이터값2, 데이터값3..)

    2. INSERT INTO 테이블이름
       VALUE (데이터값1, 데이터값2, 데이터값3..)

또한, 두번째 문법 처럼 필드이름을 생략할 수 있으며, 이 경우에는 데이터베이스의 스키마와 같은 순서대로 필드의 값이 자동적으로 대입된다. 이때 생략할 수 있는 필드는 다음과 같다. 

1. NULL을 저장할 수 있도록 설정된 필드
2. DEFAULT 제약조건이 설정된 필드
3. AUTO_INCREMENT 키워드가 설정된 필드
   
---

다음 예제는 Reservation 테이블에 새로운 레코드를 추가하는 예제이다.

    INSERT INTO Reservation(ID, NAME, ReserveDate, RoomNum)
    VALUE (5, '이순신', '2016-02-16', 1108);

![mysql_basic_insert_01](https://user-images.githubusercontent.com/82089918/153121368-ba10b78e-579b-48c0-a106-0af23bcd78fb.jpg)
-
다음 예제와 같이 추가하는 레코드가 반드시 모든 필드의 값을 가질 필요는 없다.

    INSERT INTO Reservation(ID, NAME)
    VALUES(6, '김유신');

![mysql_basic_insert_02](https://user-images.githubusercontent.com/82089918/153121640-c02a017d-8a05-419e-8e6d-c9312a77117d.jpg)

