package ru.izebit.user.ports.out.adapters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.izebit.user.ports.models.User;
import ru.izebit.user.ports.out.UserRepository;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}

@Repository
interface UserSpringRepository extends CrudRepository<UserEntity, Long> {
}

@Service
@AllArgsConstructor
class UserRepositoryImpl implements UserRepository {
    private final UserSpringRepository repository;

    @Override
    public User findById(long userId) {
        return repository
                .findById(userId).map(UserRepositoryImpl::map)
                .orElseThrow(() -> new IllegalArgumentException("can't find the user with id %s".formatted(userId)));
    }

    @Override
    public boolean deleteById(long userId) {
        repository.deleteById(userId);
        return true;
    }

    @Override
    public User store(User user) {
        return map(repository.save(map(user)));
    }

    private static User map(UserEntity user) {
        return new User(user.getId(), user.getName());
    }

    private static UserEntity map(User user) {
        return new UserEntity(user.id(), user.name());
    }
}
