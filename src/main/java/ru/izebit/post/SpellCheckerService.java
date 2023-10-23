package ru.izebit.post;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
class SpellCheckerService {
    boolean isCorrect(String text) {
        return ThreadLocalRandom.current().nextBoolean();
    }
}