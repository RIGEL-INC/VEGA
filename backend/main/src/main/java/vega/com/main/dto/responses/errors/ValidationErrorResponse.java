package vega.com.main.dto.responses.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vega.com.main.dto.AbstractDTO;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorResponse extends AbstractDTO {
    private String field;
    private String message;
}
