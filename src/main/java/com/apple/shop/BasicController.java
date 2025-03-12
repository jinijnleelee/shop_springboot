package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class BasicController {

    // 서버에서 데이터를 보내주고 싶으면 이 덩어리 가져다 쓰면 됨
    @GetMapping("/") //url을 적으면 거기로 접속하면 데이터 보내줌
    String hello(){
        return "index.html";
        //여러폴더중에 특정 파일을 꺼내고 싶을땐?  "폴더명/파일명"쓰면됨.
        //@ResponseBody == 문자 그대로 보내주세요

    }
    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "갈치사이트";

    }
    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "마이페이지입니다~";

    }
    @GetMapping("/date")
    @ResponseBody
    String data(){
        Date now = new Date();
        String nowTime = now.toString();
        return nowTime;
        //자바에서 현재날짜와 시간 보내는법
        //Date() 객체 사용
        //Date()객체는 기본적으로 toString()을 사용한다.
        //LocalDateTime.now().toString() 아니면 ZonedDateTime.now().toString()쓰는 방법도 있음

    }



}
