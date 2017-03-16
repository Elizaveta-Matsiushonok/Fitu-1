package com.linoge.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Timo on 13.01.2017.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`group`")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "group_number", nullable = false)
    private String groupNumber;

    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber='" + groupNumber + '\'' +
                '}';
    }
}
