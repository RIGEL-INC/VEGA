package vega.com.backend.common;

import lombok.Getter;

@Getter
public enum RoleTag {

    DEFAULT("default"),
    USER("user"),
    CREATOR("creator"),
    MODERATOR("moderator"),
    ADMIN("admin");

    private final String tag;

    RoleTag(String tag){
        this.tag=tag;
    }

}
