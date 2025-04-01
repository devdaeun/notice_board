package com.notice.notice_board.infastructure;

import com.notice.notice_board.domain.model.Comment;
import com.notice.notice_board.domain.repository.CommentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<Comment, Long>, CommentRepository {
}
