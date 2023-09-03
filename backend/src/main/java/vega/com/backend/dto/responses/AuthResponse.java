package vega.com.backend.dto.responses;

import lombok.*;
import vega.com.backend.common.HttpTag;
import vega.com.backend.dto.AbstractDTO;

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
