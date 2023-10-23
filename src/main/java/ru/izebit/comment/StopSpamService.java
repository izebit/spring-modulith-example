package ru.izebit.comment;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
class StopSpamService {
    boolean isSpam(String text) {
        return ThreadLocalRandom.current().nextBoolean();
    }
}