package com.linoge.models.shared;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Timo on 11.01.2017.
 */
@Data
@Builder
public class FullName {
    private String surName;
    private String firstName;
    private String patronymic;

}
