package ru.izebit.post.ports.out;


public interface UserService {
   boolean isAuthorizedToWritePosts(long userId);
}