package vega.com.main.dto.responses;

import lombok.*;
import vega.com.main.common.HttpTag;
import vega.com.main.dto.AbstractDTO;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse extends AbstractDTO {

    private HttpTag status;

    private String token;

    private NakedPersonDTO user;
}
