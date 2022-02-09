# DELETE
mysql에서는 DELETE문을 이용하여 테이블의 레코드를 삭제할 수 있다.

    DELETE FROM 테이블이름
    WHERE 필드이름 = 데이터값

DELETE문은 해당 테이블에서 WHERE절에 조건에 만족하는 레코드 값만을 지운다. <BR> 즉, 테이블에서 명시한 필드와, 그 값이 일치하는 레코드값만 지운다.

만약 WHERE절을 생략하면 모든 레코드 값을 지운다.
<BR>(테이블은 지워지지 않아 테이블까지 지울려면 DROP TABLE을 이용해야 한다.)

<BR>다음 예제는 Reservation 테이블에서 NAME 필드값인 '홍길동'을 지우는 예제이다.

    DELETE FROM Reservation
    WHERE NAME = '홍길동';

![mysql_basic_delete_01](https://user-images.githubusercontent.com/82089918/153123451-c9d17efa-e488-42f1-abbb-35536fdb4e37.jpg)
