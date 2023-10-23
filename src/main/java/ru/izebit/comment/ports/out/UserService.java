package ru.izebit.comment.ports.out;


public interface UserService {
    boolean isBlacklisted(long userId);
}