package com.notice.notice_board.application.dto.response;

import com.notice.notice_board.domain.model.Post;
import lombok.Builder;

import java.util.Date;
@Builder
public record PostResponseDto(
        Long id,
        String title,
        String content
) {

    public static PostResponseDto from(Post post) {
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
