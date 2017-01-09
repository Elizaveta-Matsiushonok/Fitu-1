package com.linoge.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.linoge.models.dto.TagDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
@Entity
@NoArgsConstructor
@Data
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToMany(mappedBy = "tags")
    @JsonBackReference
    private List<News> news;
}
