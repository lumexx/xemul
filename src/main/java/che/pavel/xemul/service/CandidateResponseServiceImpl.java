package che.pavel.xemul.service;

import che.pavel.xemul.model.CandidateResponse;
import che.pavel.xemul.repository.CandidateResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CandidateResponseServiceImpl implements CandidateResponseService {

    @Autowired
    CandidateResponseRepository candidateResponseRepository;

    @Override
    public CandidateResponse getById(Long id) { return candidateResponseRepository.getOne(id); }

    @Override
    public void save(CandidateResponse candidateResponse) { candidateResponseRepository.save(candidateResponse); }

    @Override
    public void delete(CandidateResponse candidateResponse) { candidateResponseRepository.delete(candidateResponse); }

    @Override
    public Page<CandidateResponse> findAll(Pageable pageable) { return candidateResponseRepository.findAll(pageable); }

}
