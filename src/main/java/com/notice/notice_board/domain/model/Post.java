package com.notice.notice_board.domain.model;

import com.notice.notice_board.application.dto.request.PostRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "p_posts")
@NoArgsConstructor
public class Post extends Default{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updatePost(PostRequestDto requestDto) {
        this.title = requestDto.title();
        this.content = requestDto.content();
    }
}
