package che.pavel.xemul.repository;

import che.pavel.xemul.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long>,
        PagingAndSortingRepository<Recommendation, Long> {

}