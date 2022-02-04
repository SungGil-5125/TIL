const express = require('express');
const session = require('express-session');
const MySQLStore = require('express-mysql-session')(session);
const passport = require('passport');
const GoogleStrategy = require("passport-google-oauth2").Strategy;
const { profile } = require('console');
const app = express();
require('dotenv').config();

app.set('view engine', 'ejs');
app.set('views', './passport-google/views')

const GOOGLE_CLIENT_ID = "";
const GOOGLE_CLIENT_SECRET = ""

const options = {
    host : "localhost",
    port : 3306,
    user : "root",
    password : "",
    database : "session_test",
};

const sessionStore = new MySQLStore(options);

app.use(
    session({
        secret: "secret key",
        store: sessionStore,
        resave: false,
        saveUninitialized: false,
    })
);

//image 사용을 위한 static folder 지정
app.use(express.static("public"));

//passport 초기화 및 session 연결
app.use(passport.initialize());
app.use(passport.session());

//login이 최초로 성공했을때만 호출되는 함수
//done(null,user.id)로 세션을 초기화 한다
passport.serializeUser(function (user, done){
    done(null, user.id)
})

//사용자가 페이지를 방문할 때 마다 호출되는 함수
//done(null,id)로 사용자의 정보를 각 request의 user 변수에 넣음
passport.deserializeUser(function (id, done){
    done(null, id)
})

passport.use(
    new GoogleStrategy(
        {
            clientID: GOOGLE_CLIENT_ID,
            clientSecret: GOOGLE_CLIENT_SECRET,
            callbackURL: "http://localhost:3000/auth/google/callback",
            passReqToCallback: true,
        },
        function(request, accessToken, refreshToken, profile, done){
            //console(profile);
            //console(accessToken);
            
            return done(null, profile);
        }
    )
)

app.get("/login", (req, res) => {
    if(req.user) return res.redirect("/");

    res.render('login.ejs')
});

app.get('/',(req, res)=>{
    if(!req.user) return res.redirect('/login');

    res.render('main.ejs');
})

app.get("/auth/google",passport.authenticate("google",{scope:["email", "profile"]}))

app.get("/auth/google/callback",
        passport.authenticate("google",{
            successRedirect: "/",
            failureRedirect: "/login",
        })
)

app.get('/logout', (req, res)=>{
    req.logout();
    res.redirect('/login');
})

app.listen(3000, function(){
    console.log("서버 가동중");
})