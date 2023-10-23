package ru.izebit.comment.ports.in.adapters;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.izebit.comment.ports.models.Comment;
import ru.izebit.comment.ports.in.CommentService;
import ru.izebit.user.ports.out.UserRepository;

import java.util.Collection;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
class CommentController {
    private final CommentService service;

    @PostMapping("/comments")
    Comment create(@RequestBody Comment comment) {
        return service.create(comment);
    }

    @DeleteMapping("/comments/{id}")
    boolean delete(@RequestParam("id") long commentId) {
        return service.deleteById(commentId);
    }

    @GetMapping("/comments/{id}")
    Comment get(@RequestParam("id") long commentId) {
        return service.findById(commentId);
    }


    @GetMapping("/posts/{id}/comments")
    Collection<Comment> getAllCommentsForPost(@RequestParam("id") long postId) {
        return service.findAllCommentsForPost(postId).toList();
    }
}
