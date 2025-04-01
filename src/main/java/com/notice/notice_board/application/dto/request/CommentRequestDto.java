package com.notice.notice_board.application.dto.request;

import com.notice.notice_board.domain.model.Comment;

public record CommentRequestDto(
        String content,
        Long postId
) {
    public Comment createComment() {
        return Comment.builder()
                .content(content)
                .postId(postId)
                .build();
    }
}
