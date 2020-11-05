package che.pavel.xemul.rest;


import che.pavel.xemul.model.Recommendation;
import che.pavel.xemul.service.RecommendationService;
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
@RequestMapping("/api/v1/recommendations/")
public class RecommendationRestController {

    @Autowired
    RecommendationService recommendationService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recommendation> getRecommendation(@PathVariable("id") Long recommendationId) {
        if (recommendationId == null) {
            return new ResponseEntity<Recommendation>(HttpStatus.BAD_REQUEST);
        }
        Recommendation recommendation = this.recommendationService.getById(recommendationId);
        if (recommendation == null) {
            return new ResponseEntity<Recommendation>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Recommendation>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recommendation> saveRecommendation(@RequestBody Recommendation recommendation) {
        if (recommendation == null) {
            return new ResponseEntity<Recommendation>(HttpStatus.BAD_REQUEST);
        }
        this.recommendationService.save(recommendation);
        return new ResponseEntity<Recommendation>(recommendation, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recommendation> updateRecommendation(Recommendation recommendation, UriComponentsBuilder builder) {
        if (recommendation == null) {
            return new ResponseEntity<Recommendation>(HttpStatus.BAD_REQUEST);
        }
        this.recommendationService.save(recommendation);
        return new ResponseEntity<Recommendation>(recommendation, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recommendation> deleteRecommendation(Long recommendationId) {
        Recommendation recommendation = this.recommendationService.getById(recommendationId);
        if (recommendationId == null) {
            return new ResponseEntity<Recommendation>(HttpStatus.BAD_REQUEST);
        }
        this.recommendationService.delete(recommendation);
        return new ResponseEntity<Recommendation>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Recommendation>> getAllRecommendations(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Recommendation> recommendations = this.recommendationService.findAll(pageable);
        if (recommendations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }

}
