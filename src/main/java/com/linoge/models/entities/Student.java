package com.linoge.models.entities;

import com.linoge.models.converters.FullNameConverter;
import com.linoge.models.enums.DegreeRus;
import com.linoge.models.enums.PositionRus;
import com.linoge.models.shared.FullName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Timo on 11.01.2017.
 */
@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "lector_rus")
public class LectorRus {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    @Convert(converter = FullNameConverter.class)
    private FullName fullName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "degree", nullable = true)
    @Convert()
    private DegreeRus degree;

    @Column(name = "positions", nullable = false)
    @Convert()
    private Set<PositionRus> positions;

}
