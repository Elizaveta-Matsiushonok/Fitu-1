package com.linoge.models.entities;

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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Lector> lectors;

    public void addLector(Lector lector) {
        lectors.add(lector);
    }

    public void removeLector(Lector lector) {
        lectors.remove(lector);
    }
}
