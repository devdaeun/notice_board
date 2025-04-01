package com.notice.notice_board.application.service;

import com.notice.notice_board.application.dto.request.PostRequestDto;
import com.notice.notice_board.application.dto.response.PostResponseDto;
import com.notice.notice_board.domain.model.Post;
import com.notice.notice_board.infastructure.JpaPostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    public PostResponseDto modifyPost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        post.updatePost(requestDto);
        return PostResponseDto.from(post);
    }
}
