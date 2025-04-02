package com.notice.notice_board.application.dto.request;

import com.notice.notice_board.domain.model.Comment;
import com.notice.notice_board.domain.model.Post;

public record CommentRequestDto(
        String content,
        Long postId
) {
    public Comment createComment(Post post) {
        return Comment.builder()
                .content(content)
                .post(post)
                .build();
    }
}
