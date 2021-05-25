package toy.todolist.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter // Setter 있으면 별로.. dto로 분리 필요할듯
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String password;
    private String email;
    private String role;
    @OneToMany(mappedBy = "user")
    private final List<Card> cardList = new ArrayList<>();
}
