package ru.izebit.post.ports.out.adapters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.izebit.post.ports.models.Post;
import ru.izebit.post.ports.out.PostRepository;

@Entity
@Table(name = "posts")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Long userId;
}

@Repository
interface PostSpringRepository extends CrudRepository<PostEntity, Long> {
}

@Service
@AllArgsConstructor
class PostRepositoryImpl implements PostRepository {
    private final PostSpringRepository repository;

    @Override
    public Post store(Post post) {
        return map(repository.save(map(post)));
    }

    @Override
    public boolean deleteById(long postId) {
        repository.deleteById(postId);
        return true;
    }

    @Override
    public Post findById(long postId) {
        return repository.findById(postId)
                .map(PostRepositoryImpl::map)
                .orElseThrow(() -> new IllegalArgumentException("can't find the post with id %s".formatted(postId)));
    }

    private static Post map(PostEntity e) {
        return Post.builder()
                .id(e.getId())
                .text(e.getText())
                .userId(e.getUserId())
                .build();
    }

    private static PostEntity map(Post e) {
        return PostEntity.builder()
                .id(e.id())
                .text(e.text())
                .userId(e.userId())
                .build();
    }
}
