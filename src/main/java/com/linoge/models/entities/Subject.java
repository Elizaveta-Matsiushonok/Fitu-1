package com.linoge.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Timo on 03.02.2017.
 */
@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    /**
     * Create and change with CKeditor. Contains information about subject and link on GoogleDrive.
     */
    @Column(name = "information")
    private String information;

    @ManyToMany(mappedBy = "subjects")
    @JsonBackReference
    private List<Lector> lectors;
}
