package vega.com.main.dto.responses;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import vega.com.main.dto.AbstractDTO;

@Getter
@Setter
public class ArticleDTOResp extends AbstractDTO {

    private String title;

    private String text;

    private int likes;
}
