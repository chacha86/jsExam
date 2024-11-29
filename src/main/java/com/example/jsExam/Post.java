package com.example.jsExam;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;

    @ManyToOne
    private Member author;

    public PostDto toDto() {
        PostDto dto = PostDto.builder()
                .title(this.title)
                .body(this.body)
                .authorName(author.getName())
                .build();

        return dto;
    }
}
