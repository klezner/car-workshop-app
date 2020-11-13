package pl.kl.carworkshopapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private EmploymentLevel employmentLevel;

    @Column(nullable = false)
    private Integer salary;

    @ManyToMany(mappedBy = "mechanicSet")
    private Set<RepairOrder> repairOrderSet;
}
