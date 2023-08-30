package vega.com.backend.dto.responses.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vega.com.backend.dto.AbstractDTO;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorResponse extends AbstractDTO {
    private String field;
    private String message;
}
