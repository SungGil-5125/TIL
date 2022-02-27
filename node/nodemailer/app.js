const nodemailer = require('nodemailer');
const express = require('express');
const { redirect } = require('express/lib/response');
const path = require('path');
const bodyParser = require('body-parser');
const app = express();

const EMAIL = "";
const EMAIL_PW = "";

app.set('view engine', 'ejs');
app.set('views', './views');

app.use(express.json());
app.use(bodyParser.urlencoded({ extended:true }));

app.get('/mail', (req,res)=>{
    res.render('mail.ejs');
})

let number = "";
for (let i = 0; i < 4; i++) {
    number += Math.floor(Math.random() * 10)
  }

app.post('/mail', (req, res)=>{

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
        text: '오른쪽 4자리를 입력해주세요 ' + number,
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

//위에 json을 쓰니까 req문제가 해결이 됐다