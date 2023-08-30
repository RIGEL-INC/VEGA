package vega.com.backend.dto.responses.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vega.com.backend.dto.AbstractDTO;

@Getter
@Setter
@AllArgsConstructor
public class SmallErrorMessage extends AbstractDTO {

    private String message;
}
