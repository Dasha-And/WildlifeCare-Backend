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
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "species")
    private int species;

    @Column(name = "national_park_id")
    private int nationalParkId;
}
