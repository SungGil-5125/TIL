const http = require('http');

http.createServer((req,res)=>{
    console.log("서버 가동중");
}).listen(3000);