package com.linoge.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Timo on 09.03.2017.
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "organisation")
public class Reference {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "specialist_name")
    private String specialistName;

    @Column(name = "group_number")
    private String groupNumber;

    @Column(name = "education_type")
    private String type;

    @Column(name = "education_time")
    private String time;


}
