package com.linoge.models.entities;

import com.linoge.models.enums.Registration;
import lombok.Builder;

import javax.persistence.*;

/**
 * Created by Timo on 12.01.2017.
 */
@Entity
@Builder
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "locality", nullable = false)
    private String locality;

    @Column(name = "street")
    private String street;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "begin_date")
    private String beginDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "type_of_registration")
    @Enumerated(EnumType.STRING)
    private Registration registration;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "student_reg_id")
    private Student studentRegistration;

    @ManyToOne
    @JoinColumn(name = "student_temp_id")
    private Student studentAddress;
}
