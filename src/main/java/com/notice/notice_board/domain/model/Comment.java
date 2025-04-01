package com.notice.notice_board.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "p_comments")
@NoArgsConstructor
public class Comment extends Default{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    Long Id;

    @Column(nullable = false)
    String content;

    @Column(nullable = false)
    Long postId;

    @Builder
    public Comment(String content, Long postId){
        this.content = content;
        this.postId = postId;
    }
}
