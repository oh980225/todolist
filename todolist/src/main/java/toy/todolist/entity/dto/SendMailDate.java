package toy.todolist.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
public class SendMailDate {
    private Integer yearOfSendMailDate;
    private Integer monthOfSendMailDate;
    private Integer dayOfSendMailDate;

    private  SendMailDate(LocalDate date) {
        this.yearOfSendMailDate = date.getYear();
        this.monthOfSendMailDate = date.getMonthValue();
        this.dayOfSendMailDate = date.getDayOfMonth();
    }

    public static SendMailDate of(LocalDate date) {
        return new SendMailDate(date);
    }
}
