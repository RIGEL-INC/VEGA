package vega.com.main.common;

import lombok.Getter;

@Getter
public enum RoleTag {

    ROLE_DEFAULT("DEFAULT"),
    ROLE_USER("USER"),
    ROLE_CREATOR("CREATOR"),
    ROLE_MODERATOR("MODERATOR"),
    ROLE_ADMIN("ADMIN");

    private final String tag;

    RoleTag(String tag){
        this.tag=tag;
    }

}
