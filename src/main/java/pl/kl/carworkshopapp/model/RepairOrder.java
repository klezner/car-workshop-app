package pl.kl.carworkshopapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
