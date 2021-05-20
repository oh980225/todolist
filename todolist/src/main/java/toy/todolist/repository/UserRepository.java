package toy.todolist.repository;

import toy.todolist.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUserId(String userId);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
