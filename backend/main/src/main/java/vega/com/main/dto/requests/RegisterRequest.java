package vega.com.main.dto.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vega.com.main.models.common.IPersonValidation;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest implements IPersonValidation {

    @NotBlank(message = "username should be not blank")
    @Size(min = 4, max = 254, message = "username size should be between 4 and 254")
    //UNIQUE
    private String username;

    @NotBlank(message = "password should be not blank")
    @Size(min = 4, max = 254, message = "password size should be between 4 and 254")
    private String password;
}
