const express = require('express');
const app = express();
const MongoClient = require('mongodb').MongoClient;
const methodOverride = require('method-override')
const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const session = require('express-session');
const PORT = process.env.PORT;
app.use(methodOverride('_method'))
app.use(session({secret:'비밀코드', resave:true, saveUninitialized:false}));
app.use(passport.initialize());
app.use(passport.session());
require('dotenv').config();
const ip = '10.120.74.59';
//override 사용
var db;

MongoClient.connect("mongodb+srv://ksg:kimsunggil2005!@cluster0.u4ppd.mongodb.net/myFirstDatabase?retryWrites=true&w=majority", { useUnifiedTopology: true }, function (에러, client) {
	if (에러) return console.log(에러)
	db = client.db('todoapp');

    //     db.collection('post').insertOne( {이름 : 'John', _id : 100} , function(에러, 결과){
	//     console.log('저장완료'); 
	// });

	app.listen(3000, function () {
		console.log('서버 가동중');
	});
});

const bodyparser = require('body-parser');
app.use(express.urlencoded({extended: true})) 
app.set('view engine','ejs');

app.use('/public', express.static('public'));

app.get('/', (req,res) =>{
    res.render('index.ejs');
});

app.get('/write', (req,res) =>{
    res.render('write.ejs');
});

app.get('/login', (req,res)=>{
	res.render('login.ejs');
})

app.get('/fail', (req,res)=>{
	res.render('fail.ejs');
})

app.get('/mypage', 로그인했니, (req, res)=>{
	console.log(req.user);
	res.render('mypage.ejs',{user : req.user});
})

//미들웨어
function 로그인했니(요청, 응답, next) { 
	if (요청.user) { 
	  next() 
	} 
	else { 
	  응답.send('로그인안하셨는데요?') 
	} 
  } 
  
  app.get('/list', function(req, res){
	  db.collection('post').find().toArray(function(에러, 결과){
		  console.log(결과)
		  res.render('list.ejs', { posts : 결과 })
		})
	})
	
	app.get('/detail/:id', (요청, 응답) => {
			db.collection('post').findOne({ _id: parseInt(요청.params.id) }, (err, result) => {
				console.log(result);
				응답.render('detail.ejs', { data: result });
			});
		});
	
	app.get('/edit/:id', (req,res)=>{
		db.collection('post').findOne({ _id : parseInt(req.params.id) }, (err, result)=>{
			console.log(result);
			res.render('edit.ejs', {post : result});
		})
	})
	
	app.put('/edit', function(요청, 응답){ 
		db.collection('post').updateOne( {_id : parseInt(요청.body.id) }, {$set : { 제목 : 요청.body.title , 날짜 : 요청.body.date }}, 
		function(){ 
			
			console.log(요청.body.id)
			//   console.log('수정완료') 
			응답.redirect('/list') 
		}); 
	}); 
	
	//로그인 성공 실패 검사
	app.post('/login', passport.authenticate('local', {failureRedirect : '/fail'}), function(요청, 응답){
		응답.redirect('/')
	});
	
	passport.use(new LocalStrategy({
		usernameField: 'id', //input name
		passwordField: 'pw',
		session: true,
		passReqToCallback: false,
	}, function (입력한아이디, 입력한비번, done) {
		//console.log(입력한아이디, 입력한비번);
		db.collection('login').findOne({ id: 입력한아이디 }, function (에러, 결과) {
			if (에러) return done(에러)
			
			if (!결과) return done(null, false, { message: '존재하지않는 아이디요' })
			if (입력한비번 == 결과.pw) {
				return done(null, 결과)
			} else {
				return done(null, false, { message: '비번틀렸어요' })
			}
		})
	}));
	
	//id를 이용해 세션을 저장시키는 코드(로그인 성공시 발동)
  passport.serializeUser((user, done)=>{
	  done(null, user.id);
	})
	//마이페이지 접속시 발동
	passport.deserializeUser((id, done)=>{ //id랑 user.id랑 같음
		db.collection('login').findOne({id : id}, (err, result)=>{
			if(err) {console.log(err);}
			done(null, result);
		})
	})
	
	app.post('/register', (req, res)=>{
		db.collection('login').insertOne({id : req.body.id, pw: req.body.pw}, (err, result)=>{
			res.redirect('/');
		})
	})
	
	app.post('/add', (req, res)=>{
		//action이 /add이기 때문에 /add이다
		console.log(req.user._id)
		res.send("전송완료");
		db.collection('counter').findOne({name : '게시물갯수'},(err, result)=>{
			//console.log(result.toatalPost); //총 개시물 갯수
			var total = result.totalPost;
			//console.log(req.body);
	
			//var 저장할거 = {_id : total + 1, 작성자 : req.user._id, 제목 : req.body.title, 날짜 : req.body.date};
			
			db.collection('post').insertOne( {_id : total + 1, 작성자 : req.user._id, 제목 : req.body.title, 날짜 : req.body.date}, function(err, result){
				console.log("저장 완료");
				db.collection('counter').updateOne({name : '게시물갯수'},{$inc : {totalPost:1}}, (err,result)=>{ 
					//$set = totalPost값을 ?로 바꿔달라, $inc = 지금있는 숫자에 ?을 더해달라
					if(err) return console.log(err)
					//err가 났을때 err를 표시해주는 콜백함수
				}) 
	
			});
		});
	});
	

	app.delete('/delete',(req, res) => {
		console.log(req.body);
		req.body._id = parseInt(req.body._id)
		const 삭제할데이터 = {_id : req.body._id, 작성자 : req.user._id};
		db.collection('post').deleteOne(삭제할데이터 , function(err, result){
			if(err){ console.log(err);}
			console.log("삭제완료");
			res.status(200).send({message : "성공했습니다"});
		})
	})
	// app.post('/add', function (re) {
	// 	console.log(요청.user._id)
	// 	res.send('전송완료');
	// 	db.collection('counter').findOne({ name: '게시물갯수' }, function (에러, 결과) {
	// 		var 총게시물갯수 = 결과.totalPost;
	// 		db.collection('post').insertOne({_id: 총게시물갯수 + 1, 작성자: req.user._id, 제목: 요청.body.title, 날짜: 요청.body.date }, (에러, 결과)=> {
	// 			console.log('저장완료');

	// 			db.collection('counter').updateOne({ name: '게시물갯수' }, { $inc: { totalPost: 1 } }, function (에러, 결과) {
	// 		  		if (에러) { return console.log(에러) }
	// 		})
	// 	  });
	// 	});
	//   });

	app.get('/search', (req, res)=>{
		
		const 검색조건 = [
			{
				$search: {
			index: 'titleSearch',
			text: {
			  query: req.query.value, //검색어
			  path: '제목'  // 제목날짜 둘다 찾고 싶으면 ['제목', '날짜']
			}
		  }
		},
		  {$sort : {_id : 1}}, //오름차순 정렬방법
		  { $project : { 제목 : 1, _id : 0, score: {$meta: "searchScore"}}}
	  ] 
	console.log(req.query.value);
	db.collection('post').aggregate(검색조건).toArray((err, result)=>{
		console.log(result);

		res.render('search.ejs',{posts : result})
	})
})




app.use('/board/sub', require('./routes/board.js'));