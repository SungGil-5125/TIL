const router = require('express').Router();

router.get('/sport',(req,res)=>{
    res.send('스포츠 게시판');
})

router.get('/game',(req, res)=>{
    res.send('게임 게시판');
})

module.exports = router;