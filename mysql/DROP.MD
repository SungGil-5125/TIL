# DROP
 
 mysql에서는 DROP을 이용하여 데이터베이스와 테이블을 삭제할 수 있다.

    1. DROP DATABASE
    2. DROP TABLE

---

## 데이터 베이스 삭제

DROP DATABASE 문은 해당 데이터베이스를 삭제해준다

    DROP DATABASE 데이터베이스이름;

* 데이터베이스를 삭제시 해당 테이블과 데이터도 삭제되니 조심해야한다.

---

## 테이블 삭제

DROP TABLE 문은 해당 테이블을 삭제해 준다.

    DROP TABLE 테이블이름;

* 테이블 삭제시 해당 데이터도 삭제되니 조심해야 한다.

만약 테이블 전체가 아니라 데이터만을 지우고 싶을때는 TRUNCATE TABLE 문을 사용하여 삭제할수있다.

    TRUNCATE TABLE 테이블이름;

<br>다음은 Reservation 테이블의 모든 데이터를 삭제하는 예제이다

    TRUNCATE TABLE Reservation;

<br>다음은 Reservation 테이블을 삭제하는 예제이다.

    DROP TABLE Reservation;

DROP문을 이용하여 데이터베이스와 테이블을 삭제하려고 할때, 만약 삭제하려는 데이터베이스와 테이블이 없을때는 오류가 난다.

이때 다음과 같이 IF EXISTS 절을 이용하면 삭제하려는 데이터베이스나 테이블이 존재하지 않아서 발생하는 오류를 막을 수 있다.

    1. DROP DATABASE IF EXISTS Hotel;
    2. DROP TABLE IF EXISTS Reservation;

