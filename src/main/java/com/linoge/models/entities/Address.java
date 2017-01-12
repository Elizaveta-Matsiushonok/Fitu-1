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

    @Column(name = "")

    private String street;
    private String apartment;
    private String beginDate;
    private String endDate;

    @Column(name = "type_of_registration")
    @Convert
    private Registration registration;
}
