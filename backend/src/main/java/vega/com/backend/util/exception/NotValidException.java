package vega.com.backend.util.exception;

import lombok.Getter;
import vega.com.backend.dto.responses.errors.ValidationErrorResponse;

import java.util.List;

@Getter
public class NotValidException extends RuntimeException{

    List<ValidationErrorResponse> errors;
    public NotValidException(List<ValidationErrorResponse>errors){
        this.errors=errors;
    }
}
