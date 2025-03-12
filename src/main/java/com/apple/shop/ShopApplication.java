package com.apple.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ShopApplication {
// 함수 만드는 법
	// 보통 class안에 만들음. 리턴할 값을 변수타입으로 지정.
//	String 함수이름() {
// 		return "o"; }

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);

		final String lover = "김재중";
		// 변수타입 대신 자바10부터 var 사용가능/but 팀원들이랑 상의해야함
		//final == 변수 수정불가능 , 즉 바뀌면 안되는 값을 지정하는것
		int age = 31;
		System.out.println(lover);
	// class 안에 있는 변수함수를 쓰려면?
		// - class를 복사해서 써야하는데 그 방법이 class 이름 앞에 new 클래스()로 복사해서 쓰면 됨
		// 그 복사본을 전문용어로 oblect라고 부름
		// class 안에 있는걸 꺼내쓰려면 . 찍어서 꺼내쓰면 됨
		//class 에 다른 값을 부여하고 싶으면 constructor,this 파라미터 사용

		//
		//class를 쓰는 이유
		// 관련있는 변수, 함수들 한곳에 정리가능
		//중요한 변수, 함수 원본을 지킬수있음


		Test test = new Test();
		System.out.println(test.name);
		test.hello();
		var test2 = new Test("박");
		System.out.println(test2.name);





		// if == 조건이 맞을때만 실행하고 싶을때
		// for == 특정코드를 복붙하고싶을때




	}

}
//class란 변수,함수의 보관함
class Test {
	String name = "kim";
	Test(){

	}
	void hello(){
		System.out.println("안녕");

	}
	Test(String aa){
		this.name = aa;
	}

}