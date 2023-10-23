package ru.izebit.user;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
class AuthenticationService {
    public boolean isAuthorized(long userId) {
        return ThreadLocalRandom.current().nextBoolean();
    }
}