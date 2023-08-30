package vega.com.backend.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vega.com.backend.dto.responses.errors.SmallErrorMessage;
import vega.com.backend.dto.responses.errors.ValidationErrorResponse;
import vega.com.backend.util.exception.ForbiddenFieldException;
import vega.com.backend.util.exception.NotFoundException;
import vega.com.backend.util.exception.NotValidException;
import vega.com.backend.util.response.ResponseWithStatusAndDate;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ResponseWithStatusAndDate<SmallErrorMessage>> handleException(NotFoundException e) {
        List<SmallErrorMessage> errorList = List.of(new SmallErrorMessage(e.getMessage()));

        ResponseWithStatusAndDate<SmallErrorMessage> response = new ResponseWithStatusAndDate<>(
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                errorList
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotValidException.class)
    private ResponseEntity<ResponseWithStatusAndDate<ValidationErrorResponse>> handleException(NotValidException e) {
        ResponseWithStatusAndDate<ValidationErrorResponse> response = new ResponseWithStatusAndDate<>(
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now(),
                e.getErrors()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForbiddenFieldException.class)
    private ResponseEntity<SmallErrorMessage> handleException(ForbiddenFieldException e) {

        SmallErrorMessage response = new SmallErrorMessage(
                "the fields you are trying to change are forbidden: " + e.getForbiddenFields().toString()
        );
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
}