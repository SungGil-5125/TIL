const nodemailer = require('nodemailer');
const express = require('express');
const { redirect } = require('express/lib/response');
const path = require('path');
const app = express();

const EMAIL = "";
const EMAIL_PW = "";

app.set('view engine', 'html');

app.get('/mail', (req,res)=>{
    res.sendFile(path.join(__dirname, "mail.html"));
})

let number = "";
for (let i = 0; i < 4; i++) {
    number += Math.floor(Math.random() * 10)
  }

app.post('/mail', (req, res)=>{
    console.log(req);

    const receiverEmail = req.body.user_email;

    const transport = nodemailer.createTransport({
        service:"gmail",
        auth: {
            user : EMAIL,
            pass : EMAIL_PW,
        },
    });

    const mailOptions = {
        from : EMAIL,
        to : receiverEmail,
        subject : "test",
        text: '오른쪽 4자리를 입력해주세요' + number,
    };

    transport.sendMail(mailOptions, (error, info) => {
        if(error){
            console.log(error);
            return;
        }
        
        console.log(info);
        console.log('success!');
    })
})


app.listen(3000, function(){
    console.log("서버 가동중");
})

//req로 보내는게 실패함 나중에 코드 수정이 필요할듯.. 백엔드 어렵다..