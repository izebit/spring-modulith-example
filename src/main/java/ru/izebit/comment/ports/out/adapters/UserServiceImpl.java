package ru.izebit.comment.ports.out.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.izebit.user.ports.in.UserService;

@AllArgsConstructor
@Service("comment-UserService")
class UserServiceImpl implements ru.izebit.comment.ports.out.UserService {
    private final UserService userService;

    @Override
    public boolean isBlacklisted(long userId) {
        return userService.isBlacklisted(userId);
    }
}
