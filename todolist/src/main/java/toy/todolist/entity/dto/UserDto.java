package toy.todolist.entity.dto;

import lombok.Data;

@Data
public class UserDto {
    private String userId;
    private String password;
    private String email;
}
