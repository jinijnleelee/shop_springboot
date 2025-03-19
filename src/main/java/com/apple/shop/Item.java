package com.apple.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer price;

    public Item(String title,Integer price){
        this.title = title;
        this.price = price;
    }


    //@Entity 변수들에 public을 붙이면 다른 모든 클래스에서 문제없이 사용가능. 그치만 private로 쓰는경우도 있음. 근데 private는 getter setter가 있어야함

//
//    public void setTitle(String title) {
//        if(title.length()>255){
//          //대충...오류를 보내준다던지...창을 띄운다던지...
//        }else{
//            this.title = title;
//        }
//
//    }
}
