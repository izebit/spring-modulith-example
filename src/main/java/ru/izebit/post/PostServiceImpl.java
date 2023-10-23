package ru.izebit.post;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.izebit.post.ports.in.PostService;
import ru.izebit.post.ports.models.Post;
import ru.izebit.post.ports.out.PostRepository;
import ru.izebit.post.ports.out.UserService;

@Service
@AllArgsConstructor
class PostServiceImpl implements PostService {
    private final SpellCheckerService spellCheckerService;
    private final UserService userService;
    private final PostRepository repository;

    @Override
    public Post create(Post post) {
        if (!userService.isAuthorizedToWritePosts(post.userId()))
            throw new IllegalArgumentException("user isn't authorized!");
        if (!spellCheckerService.isCorrect(post.text()))
            throw new IllegalArgumentException("the text contains mistakes!");

        return repository.store(post);
    }

    @Override
    public boolean deleteById(long postId) {
        return repository.deleteById(postId);
    }

    @Override
    public Post findById(long postId) {
        return repository.findById(postId);
    }
}