package ru.izebit.post.ports.out.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.izebit.user.ports.in.UserService;

@AllArgsConstructor
@Service("post-UserService")
public class UserServiceImpl implements ru.izebit.post.ports.out.UserService {
    private final UserService userService;

    @Override
    public boolean isAuthorizedToWritePosts(long userId) {
        return userService.isAuthorizedToWritePosts(userId);
    }
}
