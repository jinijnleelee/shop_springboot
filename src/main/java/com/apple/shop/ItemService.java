package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    //검사하거나 DB입출력하는것을 비즈니스 로직이라고 부름
    //그 비즈니스로직을 담는 클래스를 Service라고 부름
    private final ItemRepository itemRepository;

    public void saveItem(String title,Integer price){
        //파라미터를 받아와야 쓸수있기때문에 파라미터도 등록해줌

        //itemRepository도 받아와야하기때문에 등록해주기
        //어떻게? JPA 3step!기억하자! 근데! 이미 파일은 만들어줬으니

        //private final ItemRepository itemRepository; 써주고
        //@RequiredArgsConstructor 이거 붙여주면 됨
        System.out.println(title);
        System.out.println(price);

        Item addItem = new Item(title,price);

        itemRepository.save(addItem);
    }
}
