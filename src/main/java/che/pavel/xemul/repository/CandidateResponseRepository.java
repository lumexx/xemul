package che.pavel.xemul.repository;

import che.pavel.xemul.model.CandidateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CandidateResponseRepository extends JpaRepository<CandidateResponse, Long>,
        PagingAndSortingRepository<CandidateResponse, Long> {

}
