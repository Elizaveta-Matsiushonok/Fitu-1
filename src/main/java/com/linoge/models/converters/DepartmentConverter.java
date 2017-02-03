package com.linoge.models.converters;

import com.linoge.models.dto.DepartmentDTO;
import com.linoge.models.entities.Department;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 03.02.2017.
 */
public final class DepartmentConverter {
    private DepartmentConverter() {
    }

    public static List<DepartmentDTO> convertDepartmentCollectionToDTO(List<Department> departments) {
        return departments.stream()
                .map(department -> DepartmentDTO.builder()
                        .id(department.getId())
                        .description(department.getDescription())
                        .build())
                .collect(toList());
    }
}
