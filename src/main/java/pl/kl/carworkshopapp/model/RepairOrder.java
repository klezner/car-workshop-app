package pl.kl.carworkshopapp.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RepairOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderContents;

    @CreationTimestamp
    private LocalDateTime creationDate;

    private boolean orderClosed;
    private LocalDateTime closingDate;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Car car;

    @ManyToMany/*(cascade = {CascadeType.PERSIST, CascadeType.MERGE})*/
    @JoinTable(name = "mechanic_repairorders", joinColumns = @JoinColumn(name = "repairorder_id"), inverseJoinColumns = @JoinColumn(name = "mechanic_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Mechanic> mechanicSet;

    public void addMechanic(Mechanic mechanic) {
        mechanicSet.add(mechanic);
        mechanic.getRepairOrderSet().add(this);
    }

    public void removeMechanic(Mechanic mechanic) {
        mechanicSet.remove(mechanic);
        mechanic.getRepairOrderSet().remove(this);
    }
}
