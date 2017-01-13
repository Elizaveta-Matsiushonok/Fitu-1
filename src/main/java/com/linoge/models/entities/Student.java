package com.linoge.models.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.linoge.models.converters.FullNameConverter;
import com.linoge.models.converters.InstitutionsConverter;
import com.linoge.models.converters.JobsConverter;
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

    @OneToMany(mappedBy = "studentRegistration")
    @Column(name = "registration", nullable = false)
    private List<Address> registration;

    @OneToMany(mappedBy = "studentAddress")
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

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(name = "birthplace", nullable = false)
    private String birthplace;

    @Column(name = "drive_id", nullable = false)
    private Boolean driveId;

    @Column(name = "military_department", nullable = false)
    private Boolean militaryDepartment;

    @Column(name = "military_duty", nullable = false)
    private String militaryDuty;

    @Column(name = "institutions", nullable = false)
    @Convert(converter = InstitutionsConverter.class)
    private List<String> institutions;

    @Column(name = "jobs")
    @Convert(converter = JobsConverter.class)
    private List<String> jobs;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(
            name = "students_parents",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "id")
    )
    private List<Parent> parents;

    @Column(name = "need_in_hostel", nullable = false)
    private Boolean needInHostel;

    @OneToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;


    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    //журнал с отметками
}
