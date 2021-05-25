package toy.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.todolist.entity.Card;
import toy.todolist.repository.CardRepository;
import toy.todolist.repository.JpaCardRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(JpaCardRepository jpaCardRepository) {
        this.cardRepository = jpaCardRepository;
    }

    public Long saveCard(Card card) {
        cardRepository.save(card);
        return card.getId();
    }

    public List<Card> findAllCard() {
        return cardRepository.findAll();
    }

    public Optional<Card> findOneCard(Long id) {
        return cardRepository.findById(id);
    }

    public void deleteCard(Long id) {
        cardRepository.delete(id);
    }
}
