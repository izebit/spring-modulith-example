package ru.izebit.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.izebit.user.ports.in.UserService;
import ru.izebit.user.ports.models.User;
import ru.izebit.user.ports.out.UserRepository;

import java.util.concurrent.ThreadLocalRandom;

@Service("user-UserService")
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final AuthenticationService authenticationService;

    @Override
    public boolean isBlacklisted(long userId) {
        return ThreadLocalRandom.current().nextBoolean();
    }

    @Override
    public boolean isAuthorizedToWritePosts(long userId) {
        return authenticationService.isAuthorized(userId);
    }

    @Override
    public User store(User user) {
        return repository.store(user);
    }

    @Override
    public boolean deleteById(long userId) {
        return repository.deleteById(userId);
    }

    @Override
    public User findById(long userId) {
        return repository.findById(userId);
    }
}