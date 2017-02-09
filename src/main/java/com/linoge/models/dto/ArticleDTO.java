package com.linoge.models.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    public Long id;
    public String title;
    public String header;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String body;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String date;

    public List<TagDTO> tags;
}
