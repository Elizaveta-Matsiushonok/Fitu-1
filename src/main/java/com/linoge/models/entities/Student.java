package com.linoge.models.entities;


import com.linoge.models.converters.FullNameConverter;
import com.linoge.models.enums.EducationBasis;
import com.linoge.models.enums.EducationNumber;
import com.linoge.models.enums.EducationTime;
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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

    @Column(name = "student_id_number")//номер студенческого билета, нужен для создании юзера
    public String studentIdNumber;
    @Column(name = "education_basis")
    @Enumerated(EnumType.ORDINAL)
    EducationBasis basis;
    @Column(name = "education_number")
    @Enumerated(EnumType.ORDINAL)
    EducationNumber number;
    @Column(name = "education_time")
    @Enumerated(EnumType.ORDINAL)
    EducationTime time;
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "full_name", nullable = false)
    @Convert(converter = FullNameConverter.class)
    private FullName fullName;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private AdmissionOrder admissionOrder;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "student")
    private List<Organisation> organisation;
}
