package che.pavel.xemul.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "recommendations")
public class Recommendation extends BaseEntity {

    @Column(name = "company")
    private String company;

    @Column(name = "characteristic")
    private String characteristic;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    @JsonBackReference
    private Candidate candidate;
}
