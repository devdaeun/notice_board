package com.notice.notice_board.application.service;

import com.notice.notice_board.application.dto.request.CommentRequestDto;
import com.notice.notice_board.application.dto.request.CommentUpdateRequestDto;
import com.notice.notice_board.application.dto.response.CommentUpdateResponseDto;
import com.notice.notice_board.domain.model.Comment;
import com.notice.notice_board.domain.repository.CommentRepository;
import com.notice.notice_board.domain.repository.PostRepository;
import com.notice.notice_board.infastructure.JpaCommentRepository;
import com.notice.notice_board.infastructure.JpaPostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final JpaCommentRepository commentRepository;
    private final JpaPostRepository postRepository;

    public Long createComment(CommentRequestDto requestDto) {
        postRepository.findById(requestDto.postId()).orElseThrow(
                ()-> new IllegalArgumentException("존재하지않는 게시글입니다."));

        Comment comment = commentRepository.save(requestDto.createComment());
        return comment.getId();
    }

    public CommentUpdateResponseDto modifyComment(Long id, CommentUpdateRequestDto requestDto) {
        Comment comment = findCommentById(id);
        comment.updateComment(requestDto);
        return CommentUpdateResponseDto.from(comment);
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("존재하지않는 게시글입니다."));
    }
}
