package com.linoge.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.linoge.models.converters.TagConverter;
import com.linoge.models.dto.NewsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Timo on 28.12.2016.
 */
@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "header", nullable = false)
    private String header;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "date_of_record", nullable = false)
    private String date;

    @ManyToMany
    @JoinTable(
            name = "news_tags",
            joinColumns = @JoinColumn(name = "news_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
    )
    @JsonManagedReference
    private List<Tag> tags;

    public NewsDTO toDTO(){
        return NewsDTO.builder()
                .id(this.id)
                .title(this.title)
                .header(this.header)
                .tags(TagConverter.convertTagsCollectionToDTO(tags)).build();
    }
}
