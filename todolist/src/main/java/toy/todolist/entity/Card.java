package toy.todolist.entity;

import lombok.*;
import toy.todolist.entity.dto.CreatedAt;
import toy.todolist.entity.dto.SendMailDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private CreatedAt createdAt;
    @Embedded
    private SendMailDate sendMailDate;
    @ManyToOne
    private User user;
    public void setUser(User user) {
        this.user = user;
        user.getCardList().add(this);
    }
    @OneToMany(mappedBy = "card")
    private final List<ToDo> toDoList = new ArrayList<>();
}
