package che.pavel.xemul.service;

import che.pavel.xemul.model.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CandidateService {

    Candidate getById(Long id);

    void save(Candidate candidate);

    void delete(Candidate candidate);

    Page<Candidate> findAll(Pageable pageable);

}

