package com.apple.shop;
//클래스를 다른 파일에서 쓰고싶으면 위에 있는 이 파일 경로를 적어놔야 함


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RequiredArgsConstructor
@Controller
public class ItemController {

   private final ItemRepository itemRepository;
   private final ItemService itemService;


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
//-------------------------------숙제
//     Age object = new Age();
//      object.setAge(31);
//      object.setName("jin");
    //  object.OnePlusAge();
      //object.SettingAge(12);

//        System.out.println(object.OnePlusAge());
//        System.out.println(object.SettingAge(12));


        model.addAttribute("items",result);
        //      model.addAttribute("전달할데이터이름","데이터");
        return "list.html";
        //html에 서버데이터 넣어서 보내주려면 템플렌엔진 설치  (여기선 타임리프 사용)
        //서버 함수의 파라미터에  Model model 추가
        //model.addAttribute("전달할데이터이름","데이터값");
        //html에 가서 넣고싶은곳에 th:text="${name}" 적기
        }

    @GetMapping("/write")
    String write(){
       // List<Item> result = itemRepository.findAll();

     //   model.addAttribute("items",result);

        return "write.html";
        //html에 서버데이터 넣어서 보내주려면 템플렌엔진 설치  (여기선 타임리프 사용)
        //서버 함수의 파라미터에  Model model 추가
        //model.addAttribute("전달할데이터이름","데이터값");
        //html에 가서 넣고싶은곳에 th:text="${name}" 적기
    }

    //public  없으면 같은 패키지 안에서만 사용가능
    @GetMapping("/detail/{id}")
   String detail(@PathVariable("id") Long id,
                  Model model)  {



        try{
            Optional<Item>  reslut = itemRepository.findById(id);
            if (reslut.isPresent()) {
                System.out.println(reslut.get());
                model.addAttribute("data",reslut.get());
                return "detail.html";
            }else {
                return  "redirect:/list";
            }
        } catch (Exception e) {
                return  "redirect:/list";
        }





//        System.out.println(reslut.get());
//
//        if (reslut.isPresent()){
//            System.out.println(reslut.get());
//        }



    }
    @PostMapping("/add")
//    String addPost(@RequestParam Map formData){
    String addPost(
//            @ModelAttribute Item item){ ModelAttribute로 통째로 담아주고 가져오는 방법도 있음
    @RequestParam(name ="title") String title,
                   @RequestParam(name ="price") int price){


    itemService.saveItem(title,price);



        //        Map<String,Object > test = new HashMap<>();
//        test.put("name","이");
//        test.put("age",20);
        //행복사 컨트롤 + d

//        Map<String,Object > test = new HashMap<>();
//        test.put("name","이");
//        test.put("age",20);
//
//        System.out.println(formData);
//        System.out.println(test.get("name"));

        //특정페이지로 돌아가게 만드는법 = redirect:/주소
        return "redirect:/list";
//product
    }



}
