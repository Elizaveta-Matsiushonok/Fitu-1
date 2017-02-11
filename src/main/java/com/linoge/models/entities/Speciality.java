package com.linoge.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Timo on 11.01.2017.
 */
@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "speciality")
public class Speciality {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "speciality_id", nullable = false)
    private String specialityId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "speciality")
    private List<Group> groups;
}
