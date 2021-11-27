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
public class AnimalVaccinationDto {
    private int id;
    private String vaccine;
    private String animal;
    private Date date;
    private double doze;
}
