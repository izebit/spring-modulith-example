package ru.izebit.post.ports.in;


import ru.izebit.post.ports.models.Post;

public interface PostService {

    Post create(Post comment);

    boolean deleteById(long postId);

    Post findById(long postId);
}