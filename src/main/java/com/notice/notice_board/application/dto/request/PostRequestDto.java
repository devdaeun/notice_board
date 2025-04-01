package com.notice.notice_board.application.dto.request;

import com.notice.notice_board.domain.model.Post;
import com.notice.notice_board.infastructure.JpaPostRepository;

public record PostRequestDto(
        String title,
        String content
) {

    public Post createPost() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
