package com.linoge.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.linoge.models.converters.FullNameConverter;
import com.linoge.models.shared.FullName;
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
@Table(name = "lector")
public class Lector {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    @Convert(converter = FullNameConverter.class)
    private FullName fullName;


    /**
     * Create and change with CKeditor. Contains information about lector: publishing, photos, etc.
     */
    @Column(name = "information")
    @Lob
    private String information;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "lectors_subjects",
            joinColumns = @JoinColumn(name = "lector_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    @JsonManagedReference
    private List<Subject> subjects;

}
