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
@Table(name = "reference")
public class Reference {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "begin_of_")
    private String beginEducationDate;

    @Column(name = "end_of_admission")
    private String endEducationDate;

    @Column(name = "admission_order")
    private String admissionOrder;

    @Column(name = "specialist_name")
    private String specialistName;

    @Column(name = "organisation")
    private String organisation;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "group_number")
    private String groupNumber;

    //budget or pay
    @Column(name = "education_type")
    private String type;

    //day or evening
    @Column(name = "education_time")
    private String time;

    //first or second
    @Column(name = "education_number")
    private String number;

}
