package ru.izebit.comment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.izebit.comment.ports.in.CommentService;
import ru.izebit.comment.ports.out.CommentRepository;
import ru.izebit.comment.ports.out.UserService;
import ru.izebit.comment.ports.models.Comment;

import java.util.stream.Stream;

@Service
@AllArgsConstructor
class CommentServiceImpl implements CommentService {
    private final StopSpamService stopSpamService;
    private final UserService userService;
    private final CommentRepository commentRepository;

    @Override
    public Comment findById(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Stream<Comment> findAllCommentsForPost(long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    @Override
    public Comment create(Comment comment) {
        if (stopSpamService.isSpam(comment.text()))
            throw new IllegalArgumentException("text is spam!");
        if (userService.isBlacklisted(comment.userId()))
            throw new IllegalArgumentException("user is blacklisted!");

        return commentRepository.create(comment);
    }

    @Override
    public boolean deleteById(long commentId) {
        commentRepository.deleteById(commentId);
        return true;
    }
}