package toy.todolist.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String password;
    private String email;
    private String role;
    @OneToMany(mappedBy = "user")
    private List<Card> cardList;
}
