package che.pavel.xemul.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "job_vacancies")
public class JobVacancy extends BaseEntity {

    @Column(name = "job")
    private String job;

    @Column(name = "company")
    private String company;

    @Column(name = "about")
    private String about;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "jobVacancy")
    @JsonBackReference
    private Set<CandidateResponse> candidateResponses;

}
