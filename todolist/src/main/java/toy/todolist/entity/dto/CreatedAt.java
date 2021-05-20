package toy.todolist.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
public class CreatedAt {
    private Integer yearOfCreatedAt;
    private Integer monthOfCreatedAt;
    private Integer dayOfCreatedAt;

    private  CreatedAt(LocalDate date) {
        this.yearOfCreatedAt = date.getYear();
        this.monthOfCreatedAt = date.getMonthValue();
        this.dayOfCreatedAt = date.getDayOfMonth();
    }

    public static CreatedAt of(LocalDate date) {
        return new CreatedAt(date);
    }
}
