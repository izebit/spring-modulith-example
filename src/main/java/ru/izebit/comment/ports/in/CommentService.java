package ru.izebit.comment.ports.in;


import ru.izebit.comment.ports.models.Comment;

import java.util.stream.Stream;

public interface CommentService {
    Comment findById(long id);

    Stream<Comment> findAllCommentsForPost(long postId);

    Comment create(Comment comment);

    boolean deleteById(long commentId);
}