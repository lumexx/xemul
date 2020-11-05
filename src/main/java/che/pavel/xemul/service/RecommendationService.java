package che.pavel.xemul.service;

import che.pavel.xemul.model.Recommendation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecommendationService {

    Recommendation getById(Long id);

    void save(Recommendation recommendation);

    void delete(Recommendation recommendation);

    Page<Recommendation> findAll(Pageable pageable);
}
