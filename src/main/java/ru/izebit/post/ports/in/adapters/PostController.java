package ru.izebit.post.ports.in.adapters;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.izebit.post.ports.in.PostService;
import ru.izebit.post.ports.models.Post;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
class PostController {
    private final PostService service;

    @PostMapping()
    Post create(@RequestBody Post post) {
        return service.create(post);
    }

    @DeleteMapping("/{id}")
    boolean delete(@RequestParam("id") long postId) {
        return service.deleteById(postId);
    }

    @GetMapping("/{id}")
    Post get(@RequestParam("id") long postId) {
        return service.findById(postId);
    }
}
