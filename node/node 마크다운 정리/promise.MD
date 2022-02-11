# promise

```javascript
new Promise(function(resolve, reject) {

})
```
promise는 위와 같이 new promise()메소드를 호출하여 콜백함수로 선언하는게 가능하다.<br>동작에 대한 결과를 올바르게 줄 수 있다면 resolve, 동작을 실패했다면 reject 함수를 호출한다. 

## promise의 3가지 상태

프로미스는 new promise()로 프로미스를 생성하고 종료 될때 까지 3가지 상태를 갖는다.

- Pending(대기) : 비동기 처리가 아직 완료되지 않은 상태
- Fullfiled(이행) : 비동기 처리가 완료되어 프로미스가 결과 값을 반환해준 상태
- Rejected(실패) : 비동기 처리가 실패하거나 오류가 발생한 상태

![다운로드](https://user-images.githubusercontent.com/82089918/153555362-f7a45032-bcf6-4fc5-9531-89f23add8258.png)


### Pending(대기)
```javascript
new Promise();
```
위와 같이 new Promise() 메소드를 호출하면 대기 상태가 된다.
```javascript
new Promise(function(resolve, reject) {

})
```

위에서 말한것과 같이 new Promise() 메소드를 호출하면 콜백함수를 사용 가능하고 <br>인자는 resolve, reject이다.
동작이 성공했다면, resolve 메소드를 호출한다고 했는데 <br>이렇게 되면 Fuillfiled 상태가 된다.

### Fullfiled(이행)

```javascript
new Promise(function(resolve, reject) {
    resolve();
})
```
이와 같이 resolve를 호출하면 Fullfiled(이행)상태가 된다.

```javascript
function getData() {
    return new Promise ((resolve, reject) => {
        var data = 100;
        resolve(data);
    })
}

getData().then(function(resolveData){
    console.log(resolveData)
})

```
위와 같이 이행 상태가 되었을때 then()으로 결과값을 받을 수 있다.

### Rejected(실패)

```javascript
new Promise(function(resolve, reject) {
    reject();
})
```
위와 같이 reject()를 선언하면 Rejected(실패) 상태가 된다.<br> 그리고 실패한 이유를 catch()로 알수있다.

```javascript
function getData(){
    return new Promise(resolve, reject) => {
        reject(new Error("Request is failed"));
    });
}

getData().then().catch((err)=>{
    console.log(err);
})
```