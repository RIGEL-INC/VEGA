package vega.com.backend.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTOForPatchReqst {

    //@NotBlank(message = "username should be not blank")
    //@Size(min = 4, max = 254, message = "username size should be between 4 and 254")
    //UNIQUE
    private String username;

    //@NotBlank(message = "password should be not blank")
    //@Size(min = 4, max = 254, message = "password size should be between 4 and 254")
    private String password;
}
