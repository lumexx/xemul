package che.pavel.xemul.rest;


import che.pavel.xemul.model.JobVacancy;
import che.pavel.xemul.service.JobVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/vacancies/")
public class JobVacancyRestController {

    @Autowired
    JobVacancyService jobVacancyService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobVacancy> getJobVacancy(@PathVariable("id") Long jobVacancyId) {
        if (jobVacancyId == null) {
            return new ResponseEntity<JobVacancy>(HttpStatus.BAD_REQUEST);
        }
        JobVacancy jobVacancy = this.jobVacancyService.getById(jobVacancyId);
        if (jobVacancy == null) {
            return new ResponseEntity<JobVacancy>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<JobVacancy>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobVacancy> saveJobVacancy(@RequestBody JobVacancy jobVacancy) {
        if (jobVacancy == null) {
            return new ResponseEntity<JobVacancy>(HttpStatus.BAD_REQUEST);
        }
        this.jobVacancyService.save(jobVacancy);
        return new ResponseEntity<JobVacancy>(jobVacancy, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobVacancy> updateJobVacancy(JobVacancy jobVacancy, UriComponentsBuilder builder) {
        if (jobVacancy == null) {
            return new ResponseEntity<JobVacancy>(HttpStatus.BAD_REQUEST);
        }
        this.jobVacancyService.save(jobVacancy);
        return new ResponseEntity<JobVacancy>(jobVacancy, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobVacancy> deleteJobVacancy(Long jobVacancyId) {
        JobVacancy jobVacancy = this.jobVacancyService.getById(jobVacancyId);
        if (jobVacancyId == null) {
            return new ResponseEntity<JobVacancy>(HttpStatus.BAD_REQUEST);
        }
        this.jobVacancyService.delete(jobVacancy);
        return new ResponseEntity<JobVacancy>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<JobVacancy>> getAllJobVacancies(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {

        Page<JobVacancy> jobVacancies = this.jobVacancyService.findAll(pageable);
        if (jobVacancies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jobVacancies, HttpStatus.OK);
    }

}
