package wildlife.care.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {
    private int id;
    private String username;
    private String name;
    private String surname;
    private String password;
    private Date date_of_birth;
    private int nationalParkId;
    private String role;
}
