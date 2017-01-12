package com.linoge.models.entities;


import com.linoge.models.converters.FullNameConverter;
import com.linoge.models.converters.PhoneConverter;
import com.linoge.models.shared.FullName;
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
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "full_name", nullable = false)
    @Convert(converter = FullNameConverter.class)
    private FullName fullName;

    @Column(name = "registration", nullable = false)
    private List<Address> registration;

    @Column(name = "address", nullable = false)
    private List<Address> address;

    @Column(name = "contacts", nullable = false)
    @Convert(converter = PhoneConverter.class)
    private List<String> phones;

    @Column(name = "hobbies", nullable = false)//ckeditor field
    private String hobbies;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "citizenship", nullable = false)
    private String citizenship;

    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "birthplace")
    private String birthplace;

    @Column(name = "drive_id", nullable = false)
    private Boolean driveId;

    @Column(name = "military_department", nullable = false)
    private Boolean militaryDepartment;

    @Column(name = "military_duty", nullable = false)
    private String militaryDuty;

    @Column(name = "institutions", nullable = false)
    private List<String> insitutions;

    @Column(name = "jobs")
    private List<String> jobs;

    @Column(name = "parents", nullable = false)
    private List<Parent> parents;

    @Column(name = "need_in_hostel", nullable = false)
    private Boolean needInHostel;


    @OneToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;


    //номе ргруппы


    //журнал с отметками
}
