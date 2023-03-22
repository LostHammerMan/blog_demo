package com.example.blog.controller;

import com.example.blog.test.Member;
import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(html 파일) @Controller


// 사용자가 요청 -> 응답(data)
@RestController
public class HttpControllerTest {

    // 인터넷 브라우저 요청은 무조건 get 요청 밖에 할 수 없음
    @GetMapping("/getType")
    public String getTest(Member member){
        return "get 요청 " + member.getId() + "," + member.getUsername();
    }

    // insert
    @PostMapping("/postType")
    public String postTest(Member member){
        return "post 요청 " + member.getId() + "," + member.getUsername();
    }

    // insert -text
    @PostMapping("/postType2")
    public String postTest2(@RequestBody String text){
        return "post 요청 " + text;
    }

    // insert -json
    @PostMapping("/postType3")
    public String postTest3(@RequestBody Member member){
        return "post 요청 " + member.getId() + "," + member.getUsername();
    }

    // update
    public String putTest(){
        return "put 요청";
    }

    // delete
    public String deleteTest(){
        return "delete 요청";
    }
}
