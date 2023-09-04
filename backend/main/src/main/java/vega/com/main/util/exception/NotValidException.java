package vega.com.main.util.exception;

import lombok.Getter;
import vega.com.main.dto.responses.errors.ValidationErrorResponse;

import java.util.List;

@Getter
public class NotValidException extends RuntimeException{

    List<ValidationErrorResponse> errors;
    public NotValidException(List<ValidationErrorResponse>errors){
        this.errors=errors;
    }
}
