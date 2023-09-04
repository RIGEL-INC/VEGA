package vega.com.main.dto.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import vega.com.main.dto.AbstractDTO;
import vega.com.main.models.Person;

import java.time.LocalDateTime;

@Getter
@Setter
public class DetailsDTOResp extends AbstractDTO {

    private String name;

    private int age;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
