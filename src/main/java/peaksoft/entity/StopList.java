package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.time.ZonedDateTime;

@Entity
@Table(name = "stopList")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StopList {
    @Id
    @GeneratedValue(
            generator = "stopList_gen",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "stopList_gen",
            sequenceName = "stopList_seq",
            allocationSize = 1
    )
    private Long id;
    private String reason;
    private ZonedDateTime date;
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private MenuItem menuItem;


}
