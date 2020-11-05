package che.pavel.xemul.repository;

import che.pavel.xemul.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long>,
        PagingAndSortingRepository<Candidate, Long> {

}
