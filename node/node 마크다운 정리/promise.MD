# promise
## promise란? 
     js 비동기 작업의 단위이다.

## promise를 사용하는 이유?
    주로 서버에서 받은 데이터를 출력하기 위해 사용한다.
    
<br>

## promise의 후속 처리 메서드 - then/catch
+ then
    + 두개의 콜백함수를 인자로 전달 받는다.
    + 첫번째 콜백함수는 성공 할 때, 두번째는 실패 할 때 호출된다.
    + then 메서드는 promise를 반환한다.
    
+ cath
    + 예외가 발생할 때 호출한다.
    + catch 메서드는 promise를 반환한다

<br>

## promise의 정적 메서드
* resolve, reject, all, race

<br>

## promise 예제

```
    const promise = true;
    const promise = new promise((resolve,reject));//promise객체생성
    if (promise) {
        resolve("성공!");
    } else {
        reject("실패!");
    }
    })

    promise
    .then((data) => {
    console.log(data)
    })

    .catch((err) => {
    console.error(err)
    })
```

    
