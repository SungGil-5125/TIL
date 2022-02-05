# this

### this 생성자 호출


    thisTest(){
        this(0, "none product");
    }
    thisTest(int price, String product){
        this.price = price;
        this.product = product;
    }

+ 생성자 오버로딩 시 this로 다른 생성자를 호출할 수 있다.

+ this는 클래스 내부에서만 사용가능 하다.