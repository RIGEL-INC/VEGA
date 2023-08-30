package vega.com.backend.controllers.abstracts;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import vega.com.backend.controllers.interfaces.IPeopleController;
import vega.com.backend.dto.requests.PersonDTOForPatchReqst;
import vega.com.backend.dto.requests.PersonDTOReqst;
import vega.com.backend.dto.responses.PersonDTOResp;
import vega.com.backend.services.PeopleService;
import vega.com.backend.util.response.ResponseWithStatusAndDate;

@Tag(name = "People",description = "A REST controller that allows you to commit with the people of this site")
public abstract class ImplPeopleController implements IPeopleController {

    private final PeopleService peopleService;

    public ImplPeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(int id) {
        return peopleService.get(id);
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll(int page, int size) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll(String fieldName) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll(int page, int size, String fieldName) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAllWhoseUsernameStaringWith(String search) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> create(PersonDTOReqst personDTOReqst,
                                                                           BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> updatePutMethod(
            int id,
            PersonDTOReqst personDTOReqst,
            BindingResult bindingResult) {

        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> updatePatchMethod(
            int id,
            PersonDTOForPatchReqst personDTOForPatchReqst,
            BindingResult bindingResult) {

        return null;
    }

    @Override
    public HttpStatus delete(int id) {
        return null;
    }
}
