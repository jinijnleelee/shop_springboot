package com.apple.shop.item;
//클래스를 다른 파일에서 쓰고싶으면 위에 있는 이 파일 경로를 적어놔야 함


import com.apple.shop.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RequiredArgsConstructor
@Controller
public class ItemController {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final ItemService itemService;
    private final SecurityConfig securityConfig;


    //public  없으면 같은 패키지 안에서만 사용가능
    @GetMapping("/list")
    String list(Model model) {
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


        model.addAttribute("items", result);
        //      model.addAttribute("전달할데이터이름","데이터");
        return "list.html";
        //html에 서버데이터 넣어서 보내주려면 템플렌엔진 설치  (여기선 타임리프 사용)
        //서버 함수의 파라미터에  Model model 추가
        //model.addAttribute("전달할데이터이름","데이터값");
        //html에 가서 넣고싶은곳에 th:text="${name}" 적기
    }

    @GetMapping("/write")
    String write() {
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
                  Model model) {

        try {
            Optional<Item> reslut = itemRepository.findById(id);
            if (reslut.isPresent()) {
                System.out.println(reslut.get());
                model.addAttribute("data", reslut.get());
                return "detail.html";
            } else {
                return "redirect:/list";
            }
        } catch (Exception e) {
            return "redirect:/list";
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
            @RequestParam(name = "title") String title,
            @RequestParam(name = "price") int price) {


        itemService.saveItem(title, price);


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

    @PostMapping("/editForm")
//    String addPost(@RequestParam Map formData){
    String editForm(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "price") int price,
            Long id) {


        itemService.editForm(id, title, price);


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

//    @GetMapping("/edit")
//    String editItems(@RequestParam(name ="editId",defaultValue="") Long editId,
//                     Model model){
//        //
//       System.out.println(editId);
//
//
//            try{
//                Optional<Item>  reslut = itemRepository.findById(editId);
//                if (reslut.isPresent()) {
//                    System.out.println(reslut.get());
//                    model.addAttribute("data",reslut.get());
//                    return "edit.html";
//                }else {
//                    return "edit.html";
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//
//            }
//        return "edit.html";
//
//    }


    @GetMapping("/edit/{id}")
    String editItems(@PathVariable("id") Long id,
                     Model model) {
        try {
            Optional<Item> reslut = itemRepository.findById(id);
            if (reslut.isPresent()) {
                System.out.println(reslut.get());
                model.addAttribute("data", reslut.get());


                return "edit.html";
            } else {
                return "redirect:/list";
            }
        } catch (Exception e) {
            return "redirect:/list";
        }

    }

    @PostMapping("/test1")
    String test1(@RequestBody Map<String, Object> name) {
        // List<Item> result = itemRepository.findAll();

        //   model.addAttribute("items",result);
        System.out.println(name);
        System.out.println(name.get("name"));
        return "redirect:/list";
        //html에 서버데이터 넣어서 보내주려면 템플렌엔진 설치  (여기선 타임리프 사용)
        //서버 함수의 파라미터에  Model model 추가
        //model.addAttribute("전달할데이터이름","데이터값");
        //html에 가서 넣고싶은곳에 th:text="${name}" 적기
    }

    @GetMapping("/test2")
    String test2(@RequestParam String name, int age) {
        // List<Item> result = itemRepository.findAll();

        //   model.addAttribute("items",result);
        System.out.println(name);
        System.out.println(age);
        return "redirect:/list";
        //html에 서버데이터 넣어서 보내주려면 템플렌엔진 설치  (여기선 타임리프 사용)
        //서버 함수의 파라미터에  Model model 추가
        //model.addAttribute("전달할데이터이름","데이터값");
        //html에 가서 넣고싶은곳에 th:text="${name}" 적기
    }

    @DeleteMapping("/itemDelete")
    ResponseEntity<String> itemDelete(@RequestParam Long id) {
        itemRepository.deleteById(id);

        return ResponseEntity.status(200).body("삭제완료");


//        if(result.isPresent()){
//
//            Long id = result.get().getId();
//            String title = result.get().getTitle();
//            int price = result.get().getPrice();
//
//            itemService.itemDelete(id,title,price);
//            System.out.println("응 맞아~");
//            return  "redirect:/list";
//        }
        // return  "redirect:/list";
        //   model.addAttribute("items",result);


    }

    @GetMapping("/test3")
    String test3() {
        var result = new BCryptPasswordEncoder().encode("ㅜ");
        System.out.println(result);
        return "redirect:/list";
    }

    @PostMapping("/bcrytest")
    String bcrytest() {

        String result2 = new BCryptPasswordEncoder().encode("ㅇ");

        return "signUpPage.html";
    }

    @GetMapping("/signUpPage")
    String signUpPage() {


        return "signUpPage.html";
    }

    @GetMapping("/signInPage")
    String signInPage() {


        return "signInPage.html";
    }


    @PostMapping("/signUp")
    String signUp(String username, String displayName, String password) {
        try {
            String bcPassward = new BCryptPasswordEncoder().encode(password);
            Member member = new Member(username, bcPassward, displayName);
            memberRepository.save(member);


            return "redirect:/list";
        } catch (Exception e) {
            e.getMessage();

        }
        return "redirect:/signUpPage";


    }


    @PostMapping("/signIn")
    String signIn() {


        return "redirect:/signUpPage";





    }




}




