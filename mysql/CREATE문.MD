# CREATE

mysql에서는 다음과 같은 CREATE문을 이용하여 데이터 베이스와 테이블을 만들 수 있다.

    CREATE DATABASE
    CREATE TABLE

---
## 데이터 베이스 생성
아래는 데이터 베이스를 생성해주는 문법이다.

    CREATE DATABASE 데이터 베이스 이름
---

## 데이터 베이스 선택
데이터 베이스를 만들고, 해당 데이터 베이스를 사용하긴 위해서는 우선 데이터 베이스를 선택해야한다.<BR>
아래는 데이터 베이스를 선택하는 문법이다.

    USE 데이터 베이스 이름
---

## 테이블 생성
데이터 베이스는 하나 이상의 테이블로 구성되며, 이러한 테이블에 데이터를 저장하여 관리할수 있다.

    CREATE TABLE 데이터 이름
    (
        필드이름1 필드타입1,
        필드이름2 필드타입2,
        ...
    );

테이블을 생성하기 위해서는 테이블 이름, 필드(field) 목록과 각 필드의 타입을 명시해야 한다.

    CREATE TABLE test
    (
        ID INT,
        Name VARCHAR(30),
        ReserveDate DATE,
        RoomNum INT
    );

![데이터 베이스 생성](./../mysql_basic_create_01.jpg)
---

## 제약조건(constraint)

제약조건이란 데이터의 무결성을 지키기 위해 데이터를 입력받을때 실행되는 검사 규칙을 의미한다.<br>
이러한 제약조건은 CREATE문으로 테이블을 생성할때나, ALTER문으로 필드를 추가할때도 설정할수 있다.

<br>CREATE TABLE 문에서 사용할수 있는 제약조건은 다음과 같다.

1. NOT NULL : 해당 필드는 NULL값을 저장할 수 없게 된다.
2. UNIQUE : 해당 필드는 서로 다른 값을 가져야 한다.
3. PRIMARY KEY : 해당 필드가 NOT NULL과 UNIQUE 제약조건의 특성을 가져야 한다.
4. FOREIGN KEY : 하나의 테이블을 다른 테이블에 의존하게 만든다.
5. DEFAULT : 해당필드의 기본값을 설정한다.
---

# 데이터 타입

## 문자형 타입

보편적으로 많이 쓰이는 것은 CHAR(), VARCHAR(), TEXT이다.
|데이터 타입|범위|
|--|--|
|CHAR()|0~255 고정문자 길이|
|VARCHAR()|0~65535 가변문자 길이|
|INNYTEXT|0~255 문자 길이|
|TEXT|0~65535 문자 길이|
|BLOB|0~65535 문자 길이|
|MEDIUMTEXT|0~16777215 문자 길이|
|MEDIUMBLOB|0~16777215 문자 길이|
|LONGTEXT|0 ~ 4294967295 문자 길이|
|LONGBLOB|0 ~ 4294967295 문자 길이|

    CHAR() : 고정문자일때 사용한다.
    -CHAR(10)을 지정하면 10개(10Byte)의 데이터를 입력할 수 있다.
    -(char(10)지정후 5Byte를 입력해도 데이터 공간은 10Byte로 자료형 크기만큼 크기를 차지한다.)

    VARCHAR() : 가변문자일때 사용한다.
    -VARCHAR(10)을 지정하면 10(10Byte)의 데이터를 입력할 수 있다.
    -(VARCHAR(10) 지정후 데이터를 5Byte를 입력시 데이터 공간은 5Byte로 데이터 크기만큼 차지한다.) 

    CHAR, VARCHAR 차이점 : CHAR()는 검색이나 성능이 뛰어나 정형화 일때 사용되며, VARCHAR()는 가변적일때 사용한다.

    TEXT : 자연어 검색이 가능하게 하는것이므로 용량이 많이 사용하게 될때 사용한다.

    용도: 
        CHAR() : 전화번호 같이 정형화 되어 있는것으로 사용된다.
        VARCHAR() : 게시물 제목같이 가변적인 것에 사용된다.
        TEXT() : 게시판의 내용 같이 내용이 많을때 사용한다.


## 날짜형 타입

|데이터 타입|크기|최소값|
|--|--|--|
|DATE|3Byte|YYYY-MM--DD|
|DATETIME|8Byte|YYYY-MM-DD HH:MM::SS|
|TIMESTAMP|4Byte|YYYYMMDDHHMMSS|
|TIME|3Byte|HH:MM:SS|

