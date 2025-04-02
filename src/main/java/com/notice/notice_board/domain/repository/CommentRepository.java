package com.notice.notice_board.domain.repository;

import com.notice.notice_board.domain.model.Comment;
import com.notice.notice_board.domain.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository {
    Page<Comment> findAllByPost(Post post, Pageable pageable);
}
