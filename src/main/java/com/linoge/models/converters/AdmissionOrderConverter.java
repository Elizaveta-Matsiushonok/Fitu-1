package com.linoge.models.converters;

import com.linoge.models.dto.AdmissionOrderDTO;
import com.linoge.models.entities.AdmissionOrder;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 03.03.2017.
 */
public final class AdmissionOrderConverter {
    private AdmissionOrderConverter() {

    }

    public static List<AdmissionOrderDTO> convertAdssionOrderCollectionToDTO(List<AdmissionOrder> orders) {
        return orders.stream()
                .map(order -> AdmissionOrderDTO.builder()
                        .id(order.getId())
                        .name(order.getName())
                        .build())
                .collect(toList());
    }
}
