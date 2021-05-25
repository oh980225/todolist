package toy.todolist.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String detail;
    private boolean success;
    @ManyToOne
    private Card card;
}
