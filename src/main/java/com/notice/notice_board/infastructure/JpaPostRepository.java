package com.notice.notice_board.infastructure;

import com.notice.notice_board.domain.model.Post;
import com.notice.notice_board.domain.repository.PostRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostRepository extends JpaRepository<Post, Long> , PostRepository {
}
