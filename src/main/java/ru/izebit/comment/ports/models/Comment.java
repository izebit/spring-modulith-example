package ru.izebit.comment.ports.models;

import lombok.Builder;

@Builder
public record Comment(
        Long id,
        String text,
        Long userId,
        Long postId
) {
}
