# async와 await란?

자바스크립트는 싱글스레드이기 때문에 비동기 처리가 필수적이다.<br>
async와 await는 기존 동기적 처리의 단점을 보완하고 가독성을 높혀주는 코드를 작성할 수 있다.

## async와 await 쓰는법

async는 promise의 코드를 깔끔하게 줄여주기 때문에 가독성을 높혀준다.
<br>사용법은 function앞에 async만 붙혀주면 된다. 그리고 await 뒤에 오는 부분은<br> 반드시 promise를 반환해주어야 하고, async가 붙은 function도 promise를 반환해주어야 한다.

```javascript
async function test(){

}

변수 = async()=>{
        
}
```

당연한거지만 await을 쓸려면 function 앞에 async를 써야한다. promise를 사용하면서 알았다..
### async와 await를 사용했을때 차이점

```javascript
let asyncFunc1 = (msg) => {
    new Promise((resolve) => {
        setTimeout(()=>{
            resolve(`func1 : ${msg}`);
        }, 1000);
    })
}

let asyncFunc2 = (msg) => {
    new Promise((resolve) => {
        setTimeout(()=>{
            resolve(`func2 : ${msg}`);
        }, 1000);
    })
}

```

위와 같이 promise를 반환하면 함수가 있다고 가정한다. 아래는 promise를 썻을때의 예시이다.

```javascript
function promiseMain(){
    asyncFunc1('hello').then((result)=>{
        console.log(result);
        return asyncFunc2('world');
    }).then((result)=>{
        console.log(result);
    })
}
```

이번에는 async와 await를 사용했을때 코드이다.

```javascript
async function asyncMain(){
    let result = await asyncFunc1('hello');
    console.log(result);
    result = await asyncFunc2('world');
    console.log(result);
}
```

이렇게 짧은 코드로만 비교해도 확실히 promise보다 가독성이 좋다는것을 알 수 있다.

```javascript
function asyncItem(){
    return new Promise((resolve, reject) => {
        var item = [1,2,3];
        resolve(item);
    })
}

async function logItems(){
    var resultItem = await asyncItem();
    console.log(resultItem);
}
```
asyncItem 함수는 Promise()를 객체를 반환하는 함수이다. resolve() 함수를 사용했기 때문에 item 배열을 반환해야 한다. 만약 await를 반환하지 않고, promise(), then()을 사용해야 하는데 이거를 비동기적 사고를 하면서 코드를 작성해야하고 코드가 좀 길어진다면 가독성도 떨어지고 머리도 아플것이다.

## async와 await 예외처리


async & await에서 예외를 처리하는 방법은 try ~ catch이다. 프로미스에서 예외 처리를 위해 .catch()를 이용했던 것처럼 async에서는 catch { } 를 이용하면 된다. 

```javascript
async function test() {
    try {
        var user = await fetchUser();
        if (user.id === 1) {
            var todo = await fetchTodo();
            console.log(todo.title);
        }

    } catch(err) {
        console.log(error);
    }
}
```