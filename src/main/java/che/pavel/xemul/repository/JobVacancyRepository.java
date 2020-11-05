package che.pavel.xemul.repository;

import che.pavel.xemul.model.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobVacancyRepository extends JpaRepository<JobVacancy, Long>,
        PagingAndSortingRepository<JobVacancy, Long> {

}
