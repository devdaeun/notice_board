package com.notice.notice_board.application.dto.response;

import com.notice.notice_board.domain.model.Comment;
import lombok.Builder;

import java.util.Date;
@Builder
public record CommentResponseDto(
        Long id,
        String content,
        Long postId,
        Date createdAt,
        Date updatedAt,
        Boolean  isDeleted
) {

    public static CommentResponseDto from(Comment comment) {
        return CommentResponseDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .postId(comment.getPost().getId())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .isDeleted(comment.isDeleted())
                .build();
    }
}
