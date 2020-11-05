package che.pavel.xemul.rest;

import che.pavel.xemul.model.Candidate;
import che.pavel.xemul.service.CandidateService;
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
@RequestMapping("/api/v1/candidates/")
public class CandidateRestController {

    @Autowired
    CandidateService candidateService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidate> getCandidate(@PathVariable("id") Long candidateId) {
        if (candidateId == null) {
            return new ResponseEntity<Candidate>(HttpStatus.BAD_REQUEST);
        }
        Candidate candidate = this.candidateService.getById(candidateId);
        if (candidate == null) {
            return new ResponseEntity<Candidate>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Candidate>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate) {
        if (candidate == null) {
            return new ResponseEntity<Candidate>(HttpStatus.BAD_REQUEST);
        }
        this.candidateService.save(candidate);
        return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidate> updateCandidate(Candidate candidate, UriComponentsBuilder builder) {
        if (candidate == null) {
            return new ResponseEntity<Candidate>(HttpStatus.BAD_REQUEST);
        }
        this.candidateService.save(candidate);
        return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidate> deleteCandidate(Long candidateId) {
        Candidate candidate = this.candidateService.getById(candidateId);
        if (candidateId == null) {
            return new ResponseEntity<Candidate>(HttpStatus.BAD_REQUEST);
        }
        this.candidateService.delete(candidate);
        return new ResponseEntity<Candidate>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Candidate>> getAllCandidates(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Candidate> candidates = this.candidateService.findAll(pageable);
        if (candidates.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }
}

