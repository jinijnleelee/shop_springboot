package com.apple.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Age {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;

    public  int  OnePlusAge() {
        return this.age = age + 1;
    }



    public int SettingAge(int age) {

        if (age>=100||age<0){
            return this.age;
        }
        return this.age = age ;
    }

}
