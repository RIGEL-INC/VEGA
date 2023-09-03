package vega.com.backend.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vega.com.backend.dto.AbstractDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse extends AbstractDTO {

    private String token;
}
