package toy.todolist.entity;

import lombok.Builder;
import lombok.Data;
import toy.todolist.entity.dto.CreatedAt;
import toy.todolist.entity.dto.SendMailDate;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
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
    @OneToMany(mappedBy = "card")
    private List<ToDo> toDoList;
}
