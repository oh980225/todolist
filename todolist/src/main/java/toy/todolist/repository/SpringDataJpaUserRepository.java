package toy.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.todolist.entity.User;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaUserRepository extends JpaRepository<User, Long>, UserRepository {
    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long id);

    @Override
    Optional<User> findByUserId(String userId);

    @Override
    Optional<User> findByEmail(String email);

    @Override
    List<User> findAll();
}
