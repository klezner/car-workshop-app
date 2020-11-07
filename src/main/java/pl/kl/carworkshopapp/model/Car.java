package pl.kl.carworkshopapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String registrationNumber;

    @Column(nullable = false)
    private EngineType engineType;

    @Column(nullable = false)
    private Double engineCapacity;
    private Integer mileage;

    @Column(unique = true)
    private String vinNumber;
}
