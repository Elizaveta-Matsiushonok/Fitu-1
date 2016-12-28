package com.linoge.models.dto;

import com.linoge.models.entities.Tag;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
@Data
@Builder
public class NewsDTO {

    public Long id;

    public String title;

    public String header;

    public List<Tag> tags;
}
