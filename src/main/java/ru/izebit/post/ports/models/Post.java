package ru.izebit.post.ports.models;

import lombok.Builder;

@Builder
public record Post(
        Long id,
        String text,
        Long userId
) {
}
