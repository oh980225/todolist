package toy.todolist.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import toy.todolist.entity.Card;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class JpaCardRepository implements CardRepository {

    private final EntityManager em;

    public JpaCardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Card save(Card card) {
        em.persist(card);
        return card;
    }

    @Override
    public Optional<Card> findById(Long id) {
        return Optional.ofNullable(em.find(Card.class, id));
    }

    @Override
    public List<Card> findByUserId(Integer userId) {
        return em.createQuery("select c from Card c where c.user_id  = :user_id", Card.class)
                .setParameter("user_id", userId)
                .getResultList();
    }

    @Override
    public List<Card> findByDateAndUserId(Integer userId, LocalDate date) {
        return em.createQuery("select c from Card c where c.user_id  = :user_id", Card.class)
                .setParameter("user_id", userId)
                .getResultList();
    }

    @Override
    public List<Card> findAll() {
        return em.createQuery("select c from Card c", Card.class)
                .getResultList();
    }

    @Override
    public void delete(Long id) {
        try {
            Card card = Optional.ofNullable(em.find(Card.class, id)).orElseThrow(NullPointerException::new);
            em.remove(card);
            log.info("ID: " + id + "인 Card 삭제");
        } catch (NullPointerException e) {
            log.error("해당 객체가 존재하지 않습니다.");
        }
    }
}
