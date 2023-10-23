package ru.izebit.post.ports.out;

import ru.izebit.post.ports.models.Post;

public interface PostRepository {
    Post store(Post post);

    boolean deleteById(long postId);

    Post findById(long postId);
}
