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
 * Created by Timo on 12.01.2017.
 */
@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    @Convert(converter = FullNameConverter.class)
    private FullName fullName;

    @Column(name = "registration", nullable = false)
    private List<Address> registration;

    @Column(name = "contacts", nullable = false)
    @Convert(converter = PhoneConverter.class)
    private List<String> phones;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "jobs")
    private List<String> jobs;
}
