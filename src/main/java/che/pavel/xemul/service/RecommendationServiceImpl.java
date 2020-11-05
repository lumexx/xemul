package che.pavel.xemul.service;

import che.pavel.xemul.model.Recommendation;
import che.pavel.xemul.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    RecommendationRepository recommendationRepository;

    @Override
    public Recommendation getById(Long id) { return recommendationRepository.getOne(id); }

    @Override
    public void save(Recommendation recommendation){ recommendationRepository.save(recommendation); }

    @Override
    public void delete(Recommendation recommendation) { recommendationRepository.delete(recommendation); }

    @Override
    public Page<Recommendation> findAll(Pageable pageable) { return recommendationRepository.findAll(pageable); }

}