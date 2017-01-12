package com.linoge.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Timo on 11.01.2017.
 */
@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "department")
public class Speciality {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "speciality")
    @Column(name = "name")
    private String name;
}
