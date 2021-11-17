package wildlife.care.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "animal_vaccination")
public class AnimalVaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "vaccine_id")
    private int vaccine_id;

    @Column(name = "animal_id")
    private int animal_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "doze")
    private double doze;
}
