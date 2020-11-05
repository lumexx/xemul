package che.pavel.xemul.service;

import che.pavel.xemul.model.Candidate;
import che.pavel.xemul.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public Candidate getById(Long id) {
        return candidateRepository.getOne(id);
    }

    @Override
    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public void delete(Candidate candidate) {
        candidateRepository.delete(candidate);
    }

    @Override
    public Page<Candidate> findAll(Pageable pageable) {
        return candidateRepository.findAll(pageable);
    }
}
