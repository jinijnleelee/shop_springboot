package com.apple.shop;

import jakarta.persistence.*;

@Entity
public class Item {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer id;


public String title;
public Integer price;
//@Entity 변수들에 public을 붙이면 다른 모든 클래스에서 문제없이 사용가능. 그치만 private로 쓰는경우도 있음. 근데 private는 getter setter가 있어야함

}


