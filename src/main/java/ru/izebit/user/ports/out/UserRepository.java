package ru.izebit.user.ports.out;

import ru.izebit.user.ports.models.User;

public interface UserRepository {
    User findById(long userId);

    boolean deleteById(long userId);

    User store(User user);
}
