package com.example.jsExam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "hello";
    }

    @GetMapping("/post")
    @ResponseBody
    public Post post() {

        Post post = Post.builder()
                .title("제목1")
                .body("내용1")
                .author("홍길동")
                .build();

        return post; // 스프링부트 컨트롤러에서 객체를 리턴하면 JSON으로 변환된다.
    }
}
