package ru.izebit.user.ports.in;


import ru.izebit.user.ports.models.User;

public interface UserService {
    boolean isBlacklisted(long userId);

    boolean isAuthorizedToWritePosts(long userId);

    User store(User user);

    boolean deleteById(long userId);
    User findById(long userId);
}