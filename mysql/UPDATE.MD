# UPDATE
mysql에서는 UPDATE문으로 레코드의 내용을 수정할 수 있다.

    UPDATE 테이블이름
    SET 필드이름1 = 데이터값1, 필드이름2 = 데이터값2,...
    WHERE 필드이름 = 데이터값

UPDATE문은 해당 테이블에서 WHERE절의 조건을 만족하는 레코드의 값만 수정한다.

---

다음예제는 NAME의 필드의 값이 '홍길동'인 모든 레코드의 RoomNum을 변경하는 예제이다.

    UPDATE Reservation
    SET RoomNum = 2002;
    WHERE NAME = '홍길동';

![mysql_basic_update_01](https://user-images.githubusercontent.com/82089918/153122413-cdfaa256-cbe8-4ea1-9d57-fbfbb387c913.jpg)

만약 WHERE절을 생략하면 RoomNum이 다 2002로 변경된다.

    UPDATE Reservation
    SET RoomNum = 2002;

![mysql_basic_update_02](https://user-images.githubusercontent.com/82089918/153122675-ebf009d7-8e3d-4e94-be92-56ac6381b1c6.jpg)
