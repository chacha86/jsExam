package com.example.jsExam;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @PostConstruct
    public void init() {

        if( memberRepository.count() > 0 ) {
            return;
        }

        Member m1 = Member.builder()
                .name("홍길동")
                .build();

        memberRepository.save(m1);

        Post post1 = Post.builder()
                .title("제목1")
                .body("내용1")
                .author(m1)
                .build();

        Post post2 = Post.builder()
                .title("제목2")
                .body("내용2")
                .author(m1)
                .build();

        postRepository.save(post1);
        postRepository.save(post2);

    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "hello";
    }



    @GetMapping("/post")
    @ResponseBody
    public List<PostDto> post() {

        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();

        for(Post post : posts) {
            PostDto dto = post.toDto();
            postDtos.add(dto);
        }

        return postDtos; // 스프링부트 컨트롤러에서 객체를 리턴하면 JSON으로 변환된다.
    }
}
