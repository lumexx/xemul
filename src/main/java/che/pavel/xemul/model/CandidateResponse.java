package che.pavel.xemul.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "candidate_responses")
public class CandidateResponse extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="job_vacancy_id")
    @JsonManagedReference
    private JobVacancy jobVacancy;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    @JsonManagedReference
    private Candidate candidate;

}
