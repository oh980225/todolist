package toy.todolist.repository;

import toy.todolist.entity.Card;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CardRepository {
    Card save(Card card);
    Optional<Card> findById(Long id);
    List<Card> findByUserId(Integer userId);
    List<Card> findByDateAndUserId(Integer userId, LocalDate date);
    List<Card> findAll();
    void delete(Long id);
}
