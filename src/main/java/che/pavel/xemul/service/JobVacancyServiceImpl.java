package che.pavel.xemul.service;

import che.pavel.xemul.model.JobVacancy;
import che.pavel.xemul.repository.JobVacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JobVacancyServiceImpl implements JobVacancyService {

    @Autowired
    JobVacancyRepository jobVacancyRepository;

    @Override
    public JobVacancy getById(Long id) { return jobVacancyRepository.getOne(id); }

    @Override
    public void save(JobVacancy jobVacancy) { jobVacancyRepository.save(jobVacancy); }

    @Override
    public void delete(JobVacancy jobVacancy) { jobVacancyRepository.delete(jobVacancy); }

    @Override
    public Page<JobVacancy> findAll(Pageable pageable) { return jobVacancyRepository.findAll(pageable); }

}
