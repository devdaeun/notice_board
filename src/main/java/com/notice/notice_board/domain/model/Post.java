package com.notice.notice_board.domain.model;

import jakarta.persistence.*;

@Entity
public class Post extends Default{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private int Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

}
