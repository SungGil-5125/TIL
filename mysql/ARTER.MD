# ALTER
mysql에서는 ARTER문으로 데이터 베이스와 테이블을 수정할 수 있다.
    
    ALTER DATABASE
    ALTER TABLE

---
## 데이터 베이스 수정

ALTER DATABASE 문은 데이터 베이스의 전체적인 특성을 수정할 수 있게 해준다. <BR>이러한 데이터 베이스의 특성은 데이터 베이스의 디렉터리의 db.opt 파일에 저장되어 있다.

<br>다음과 같은 문으로 데이터 베이스의 문자 집합이나 콜레이션을 변경할 수 있다.
<br>콜레이션 :  데이터 베이스에서 검색이나 정렬같은 작업을 할때 사용하는 비교를 위한 규칙의 집합이라고 한다.

    1. ALTER DATABASE 데이터베이스이름 CHARACTER SET = 문자집합이름
    2. ALTER DATABASE 데이터베이스이름 COLLATE = 콜레이션이름

다음 예제는 Hotel 데이터베이스 문자집합과 컬레이션을 변경하는 예제이다.

    ALTER DATABASE Hotel CHARACTER SET = euckr_bin COLLATE = euckr_korean_ci;

자주 사용되는 CHARACTER SET은 다음과 같다.

    1. utf8 : UTF-8 유니코드를 지원하는 문자셋(1~3바이트)
    2. euckr : 한글을 지원하는 문자셋(1~2바이트)

또한 자주 사용되는 COLLATE는 다음과 같다

    1. utf8_bin
    2. utf8_general_ci(기본설정)
    3. eckr_bin
    4. eckr_korean_ci
   
ci는 case-insensitive를 의미하며, 대소문자를 구분하지 않는다.

---

## 테이블 수정

ALTER TABLE은 테이블에 필드를 추가, 삭제, 데이터 타입 변경할 수 있다.

    1. ADD
    2. DROP
    3. MODIFY COLUMN
   
---
## 새로운 필드 추가

ALTER TABLE문과 ADD를 추가하면 테이블에 필드를 추가해준다

    ALTER TABLE 테이블이름 ADD 필드이름_필드타입;

다음예제는 Reservation 테이블에 타입이 INT인 Phone 필드를 추가해주는 예제다.

    ALTER TABLE Reservation
    ADD Phone_INT;

![mysql_basic_alter_01](https://user-images.githubusercontent.com/82089918/152911822-1e9693d5-c24f-4e27-b2ce-933dfb72672f.jpg)

(👆CREATE에서 만들었던 테이블임)

---

## 기존 필드 삭제

ALTER TABLE문에 DROP을 추가하면 테이블의 필드가 삭제된다.

    ALTER TABLE 테이블이름 DROP 필드이름;

다음예제는 Reservation 테이블에서 RoomNum 필드를 삭제하는 예제다.

    ALTER TABLE Reservation DROP RoomNum;

![mysql_basic_alter_02](https://user-images.githubusercontent.com/82089918/152911868-5da723ad-be73-47c0-bba1-adfff66f8a74.jpg)

---

## 필드 타입 변경

ALTER TABLE문에 MODIFY COLUMN을 추가하면 필드의 타입을 변경할 수 있다.

    ALTER TABLE 테이블이름 MODIFY COLUMN 필드이름_필드타입;

다음 예제는 Reservation 테이블의 ReserveDate 필드타입을 DATE에서 VARCHAR(20)으로 변경해주는 예제다.

    ALTER TABLE Reservation MODIFY COLUMN ReserveDate_varchar(20);

![mysql_basic_alter_03](https://user-images.githubusercontent.com/82089918/152912045-314cc9db-7b44-4be8-8a3c-e9449aa311b4.jpg)
