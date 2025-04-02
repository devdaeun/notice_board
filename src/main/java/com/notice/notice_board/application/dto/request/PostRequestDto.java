package com.notice.notice_board.application.dto.request;

import com.notice.notice_board.domain.model.Post;

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
