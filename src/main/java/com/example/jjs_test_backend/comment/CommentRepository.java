package com.example.jjs_test_backend.comment;

import com.example.jjs_test_backend.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
