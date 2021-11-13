package wildlife.care.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "heart_rate_high_limit")
    private int heart_rate_high_limit;

    @Column(name = "heart_rate_low_limit")
    private int heart_rate_low_limit;

    @Column(name = "normal_temperature")
    private double normal_temperature;

    @Column(name = "icon_url")
    private String icon_url;
}
