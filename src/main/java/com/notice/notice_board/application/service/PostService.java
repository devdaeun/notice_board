package com.notice.notice_board.application.service;

import com.notice.notice_board.application.dto.request.PostRequestDto;
import com.notice.notice_board.domain.model.Post;
import com.notice.notice_board.infastructure.JpaPostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final JpaPostRepository postRepository;

    public Long createPost(PostRequestDto requestDto) {
        Post post = postRepository.save(requestDto.createPost());
        return post.getId();
    }
}
