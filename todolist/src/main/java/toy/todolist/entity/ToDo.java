package toy.todolist.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String detail;
    private boolean success;
    @ManyToOne
    private Card card;
}
