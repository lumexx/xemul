package che.pavel.xemul.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "candidates")
public class Candidate extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "about")
    private String about;

    @OneToOne(mappedBy = "candidate")
    @JsonBackReference
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "candidate")
    private Set<Recommendation> recommendations;

    @JsonBackReference
    @OneToMany(mappedBy = "candidate")
    private Set<CandidateResponse> candidateResponses;


}
