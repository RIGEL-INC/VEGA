package vega.com.backend.dto.responses;

import lombok.Getter;
import lombok.Setter;
import vega.com.backend.dto.AbstractDTO;

import java.util.List;

@Getter
@Setter
public class PersonDTOResp extends AbstractDTO {

    private String username;
    private String role;

    private DetailsDTOResp info;

    private List<ArticleDTOResp> articles;
}
