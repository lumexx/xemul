package che.pavel.xemul.service;

import che.pavel.xemul.model.JobVacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobVacancyService {

    JobVacancy getById(Long id);

    void save(JobVacancy jobVacancy);

    void delete(JobVacancy jobVacancy);

    Page<JobVacancy> findAll(Pageable pageable);
}
