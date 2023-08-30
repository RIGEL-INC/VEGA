package vega.com.backend.dto.responses;

import lombok.Getter;
import lombok.Setter;
import vega.com.backend.dto.AbstractDTO;

@Getter
@Setter
public class PersonDTOResp extends AbstractDTO {

    private String username;
}
