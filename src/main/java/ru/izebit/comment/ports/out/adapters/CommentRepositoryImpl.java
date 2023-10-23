package ru.izebit.comment.ports.out.adapters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.izebit.comment.ports.models.Comment;
import ru.izebit.comment.ports.out.CommentRepository;

import java.util.stream.Stream;


@Entity
@Table(name = "comments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Long userId;
    private Long postId;
}

@Repository
interface CommentSpringRepository extends CrudRepository<CommentEntity, Long> {
    Stream<CommentEntity> findAllByPostId(Long postId);
}

@Service
@AllArgsConstructor
class CommentRepositoryImpl implements CommentRepository {
    private final CommentSpringRepository repository;

    @Override
    public Comment findById(long id) {
        return repository.findById(id)
                .map(CommentRepositoryImpl::map)
                .orElseThrow();
    }

    @Override
    public Stream<Comment> findAllByPostId(long postId) {
        return repository.findAllByPostId(postId)
                .map(CommentRepositoryImpl::map);
    }

    @Override
    public Comment create(Comment comment) {
        return map(repository.save(map(comment)));
    }

    @Override
    public void deleteById(long commentId) {
        repository.deleteById(commentId);
    }

    private static Comment map(CommentEntity e) {
        return Comment.builder()
                .id(e.getId())
                .text(e.getText())
                .postId(e.getPostId())
                .userId(e.getUserId())
                .build();
    }

    private static CommentEntity map(Comment e) {
        return CommentEntity.builder()
                .id(e.id())
                .text(e.text())
                .postId(e.postId())
                .userId(e.userId())
                .build();
    }
}
