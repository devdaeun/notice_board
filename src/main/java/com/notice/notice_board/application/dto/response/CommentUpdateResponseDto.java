package com.notice.notice_board.application.dto.response;

import com.notice.notice_board.domain.model.Comment;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
@Builder
public record CommentUpdateResponseDto(
        Long id,
        String content,
        Long postId,
        Date updatedAt
) {

    public static CommentUpdateResponseDto from(Comment comment) {
        return CommentUpdateResponseDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .postId(comment.getPostId())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
