package vega.com.backend.util.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ForbiddenFieldException extends RuntimeException{

    List<String> forbiddenFields;
    public ForbiddenFieldException(List<String> forbiddenFields){
        this.forbiddenFields=forbiddenFields;
    }

}
