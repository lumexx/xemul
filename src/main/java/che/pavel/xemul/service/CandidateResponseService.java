package che.pavel.xemul.service;

import che.pavel.xemul.model.CandidateResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CandidateResponseService {

    CandidateResponse getById(Long id);

    void save(CandidateResponse candidateResponse);

    void delete(CandidateResponse candidateResponse);

    Page<CandidateResponse> findAll(Pageable pageable);

}
