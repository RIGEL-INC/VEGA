package vega.com.backend.common;

import lombok.Getter;

@Getter
public enum HttpTag {
    OK(200,"OK"),
    AUTHENTICATED(210,"AUTHENTICATED"),
    NOT_FOUND(404, "NOT FOUND"),
    FORBIDDEN(403, "FORBIDDEN"),
    UNAUTHORIZED(401,"UNAUTHORIZED"),
    BAD_REQUEST(400,"BAD REQUEST");

    private final int code;

    private final String message;

    HttpTag(int code, String message){
        this.code=code;
        this.message=message;
    }
}
