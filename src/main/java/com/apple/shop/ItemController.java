package com.apple.shop;
//클래스를 다른 파일에서 쓰고싶으면 위에 있는 이 파일 경로를 적어놔야 함


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Controller
public class ItemController {

   private final ItemRepository itemRepository;


    //public  없으면 같은 패키지 안에서만 사용가능
    @GetMapping("/list")
    String list(Model model){
      List<Item> result = itemRepository.findAll();
       //List<출력중인 테이블 클래스 넣어야함 >
//        System.out.println(result.get(0).price);
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(30);
//        a.add(40);
//        System.out.println(a.get(0));
//        System.out.println(a.get(1));
//
//        var aa = new Item();
//        aa.setTitle("dsda");
//        System.out.println(aa.toString());

        model.addAttribute("items",result);
        //      model.addAttribute("전달할데이터이름","데이터");
        return "list.html";
        //html에 서버데이터 넣어서 보내주려면 템플렌엔진 설치  (여기선 타임리프 사용)
        //서버 함수의 파라미터에  Model model 추가
        //model.addAttribute("전달할데이터이름","데이터값");
        //html에 가서 넣고싶은곳에 th:text="${name}" 적기
    }

}
