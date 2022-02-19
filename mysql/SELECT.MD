# SELECT

mysql에서는 SELECT문을 사용하여 테이블의 레코드를 선택할 수 있다.

    SELECT 필드이름
    FROM 테이블이름
    [WHERE 조건]

FROM절은 레코드를 선택할 테이블의 이름을 명시합니다.
<BR>이때 WHERE절을 사용하면, 선택할 레코드의 조건을 좀 더 자세히 설정할 수 있다. 

---

## 테이블의 모든 필드 선택
SELECT문에 *를 사용하면 모든 필드를 선택한다.
```mysql
SELECT *
FROM 테이블 이름
```

이 방식은 모든 필드를 사용하게 될때 유용하다.<br>
다음 예제는 Reservation 테이블에 모든 필드를 선택하는 예제이다.

![mysql_basic_select_01](https://user-images.githubusercontent.com/82089918/153124236-e85085a5-aaee-481a-9642-2dd4cf597b98.jpg)

---
## 특정 조건의 레코드 선택

SELECT 문과 함께 WHERE 절을 사용하면, 검색할 레코드의 조건을 설정할 수 있다. <BR>이러한 WHERE절은 테이블이 너무 크거나, 특정 조건에 맞는 레코드만을 선택하고 싶을때 사용한다.
<BR>다음예제는 NAME값이 홍길동인 레코드만을 선택하는 예제이다.

    SELEECT *
    FROM Reservation
    WHERE NAME = '홍길동';

![mysql_basic_select_02](https://user-images.githubusercontent.com/82089918/153125848-ce58af62-2481-4ecc-8ca1-d1f591751946.jpg)

이러한 WHERE절에는 여러개의 조건을 설정할 수 있다.<BR>
이때 여러개의 조건은 AND와 OR 연산자를 이용하여 연결한다.
<BR><BR>다음 예제는 ID값이 3 이하이면서 ReserveDate 필드값이 2016년 2월 1일 이후인 레코드만을 <br>선택하는 예제이다.

    SELECT *
    FROM ReserveDate
    WHERE ID <= 3 && ReserveDate >= '2016-02-01';

![mysql_basic_select_03](https://user-images.githubusercontent.com/82089918/153126363-9474c131-c597-41a3-8218-6b3b83f01b63.jpg)

---

## 특정 필드만 선택

SELECT 키워드 다음에 필드이름을 명시하면, 해당 테이블의 특정 필드만 불러올 수 있다.<BR>
이때 쉼표를 사용하여 여러개의 필드이름을 한 번에 명시할 수 있다.
<BR><BR>다음 예제는 Reservation 테이블에서 Name필드와 RoomNum 필드만 선택하는 예제이다.

    SELECT Name, RoomNum
    FROM Reservation;

![mysql_basic_select_04](https://user-images.githubusercontent.com/82089918/153126933-324640f7-f02d-407b-9b7c-95b92252ea4b.jpg)

이때에도 WHERE절을 이용해서 특정조건을 만족하는 레코드만을 선택할 수 있다.
<BR><BR>다음 예제는 ID값이 3 이하이면서 ReserveDate 필드값이 2016년 2월 1일 이후인 레코드의 Name 필드와 ReserveDate 필드만을 선택하는 예제이다.

    SELECT Name, RoomNum
    FROM Reservation
    WHERE ID <= 3 AND ReserveDate >= '2016-02-01';

![mysql_basic_select_06](https://user-images.githubusercontent.com/82089918/153127297-626c0220-a4e3-4039-a350-5d93656933fd.jpg)

---

## 중복되는 값 제거
만약 같은 필드에 중복되는 레코드 값이 있다면, <BR>DISTINCT 키워드를 사용하여 그 값이 한번만 선택되도록설정 할 수 있다.

<BR>다음 예제는 Reservation 테이블에 Name필드를 사용하는 예제이다. <BR>이때 DISTINCT를 사용했기때문에 한번밖에 표시가 안된다.

    SELECT DISTINCT Name
    FROM Reservation;

![mysql_basic_select_05](https://user-images.githubusercontent.com/82089918/153128034-93003587-2bfb-4673-a7ad-a905bcdc1c9e.jpg)

--- 

## 선택된 결과 정렬

SELECT 문으로 선택된 결과를 ORDER BY절으로 정렬할 수 있다.
<BR>ORDER BY의 기본설정은 오름차순이며, ASC 키워드를 사용하여 직접 오름차순을 명시할 수 있다.

<BR>다음 예제는 Reservation 테이블의 모든 레코드를 ReserveDate 필드의 오름차순으로 정렬해 주는 예제이다.

    SELECT *
    FROM Reservation
    ORDER BY ReserveDate;

![mysql_basic_select_07](https://user-images.githubusercontent.com/82089918/153128796-34f256d5-8f66-446e-a6cc-0467994c7542.jpg)

내림차순으로 정렬하고 싶을때는 맨 마지막에 DESC키워드를 추가해주면 된다.

    SELECT *
    FROM Reservation
    ORDER BY ReserveDate DESC;

![mysql_basic_select_08](https://user-images.githubusercontent.com/82089918/153128992-040008c7-0359-453c-a526-80a3d6e8336f.jpg)


PHP에서는 데이터 타입이 문자열일때 대소문자 구분을 하지 않지만,<BR>대소문자까지 구분을 하려면 ORDER BY BINARY 절을 사용한다.
<BR>또한, 여러 필드의 데이트를 ,(쉼표)를 사용하여 한번에 정렬할 수 있다.

<BR>다음예제는 Reservation 테이블의 모든 레코드를 먼저 ReserveDate 필드의 내림차순으로 정렬한뒤, 또 다시 RoomNum 필드의 내림차순으로 정렬하는 예제이다.

    SELECT *
    FROM Reservation
    ORDER BY ReserveDate DESC, RoomNum DESC;

![mysql_basic_select_09](https://user-images.githubusercontent.com/82089918/153131927-b9d64dee-032a-4232-ae00-fde0bff12fd8.jpg)

---

## 별칭(alias)를 이용한 처리

mysql에서는 테이블과 필드에 임시로 별칭을 부여하고, 해당 별칭을 SELECT문에 사용할 수 있다. <BR>이러한 별칭은 테이블이름이나 필드의 이름이 복잡할때 더 쉽게 읽을수 있도록 만들어 준다.

    1. SELECT 필드이름 AS 별칭
       FROM 테이블이름

    2. SELECT 필드이름
       FROM 테이블이름 AS 별칭

<br>다음 예제는 Reservation 테이블의 RoomNum 필드와 Name 필드에<br> 하나의 새로운 별칭을 부여하는 예제이다.

    SELECT ReserveDate, CONCAT(RoomNum, " : ",Name) AS ReserveInfo
    FROM Resevation;

![mysql_basic_select_10 (1)](https://user-images.githubusercontent.com/82089918/153132890-dd17c85a-df98-40b5-8913-a17915857636.jpg)


CONCAT() : 인수로 전달받은 문자열을 모두 결합하여 하나의 문자열로 반환하는 함수이다.