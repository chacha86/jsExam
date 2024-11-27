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
    public String post() {
        return """
                {
                    "title" : "제목1",
                    "body" : "내용1",
                    "author" : "홍길동"
                }
                """;
    }
}
