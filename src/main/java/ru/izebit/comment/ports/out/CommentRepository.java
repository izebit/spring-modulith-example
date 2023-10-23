package ru.izebit.comment.ports.out;

import ru.izebit.comment.ports.models.Comment;

import java.util.stream.Stream;

public interface CommentRepository {
    Comment findById(long id);

    Stream<Comment> findAllByPostId(long postId);

    Comment create(Comment comment);

    void deleteById(long commentId);
}
