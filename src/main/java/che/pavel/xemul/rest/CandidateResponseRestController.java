package che.pavel.xemul.rest;

import che.pavel.xemul.model.CandidateResponse;
import che.pavel.xemul.service.CandidateResponseService;
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
@RequestMapping("/api/v1/responses/")
public class CandidateResponseRestController {

    @Autowired
    CandidateResponseService candidateResponseService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CandidateResponse> getCandidateResponse(@PathVariable("id") Long candidateResponseId) {
        if (candidateResponseId == null) {
            return new ResponseEntity<CandidateResponse>(HttpStatus.BAD_REQUEST);
        }
        CandidateResponse candidateResponse = this.candidateResponseService.getById(candidateResponseId);
        if (candidateResponse == null) {
            return new ResponseEntity<CandidateResponse>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CandidateResponse>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CandidateResponse> saveCandidateResponse(@RequestBody CandidateResponse candidateResponse) {
        if (candidateResponse == null) {
            return new ResponseEntity<CandidateResponse>(HttpStatus.BAD_REQUEST);
        }
        this.candidateResponseService.save(candidateResponse);
        return new ResponseEntity<CandidateResponse>(candidateResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CandidateResponse> updateCandidateResponse(CandidateResponse candidateResponse, UriComponentsBuilder builder) {
        if (candidateResponse == null) {
            return new ResponseEntity<CandidateResponse>(HttpStatus.BAD_REQUEST);
        }
        this.candidateResponseService.save(candidateResponse);
        return new ResponseEntity<CandidateResponse>(candidateResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CandidateResponse> deleteCandidateResponse(Long candidateResponseId) {
        CandidateResponse candidateResponse = this.candidateResponseService.getById(candidateResponseId);
        if (candidateResponseId == null) {
            return new ResponseEntity<CandidateResponse>(HttpStatus.BAD_REQUEST);
        }
        this.candidateResponseService.delete(candidateResponse);
        return new ResponseEntity<CandidateResponse>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CandidateResponse>> getAllCandidateResponses(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {

        Page<CandidateResponse> candidateResponses = this.candidateResponseService.findAll(pageable);
        if (candidateResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(candidateResponses, HttpStatus.OK);
    }


}
