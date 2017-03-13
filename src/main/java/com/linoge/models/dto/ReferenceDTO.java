package com.linoge.models.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Timo on 13.03.2017.
 */
@Data
@Builder
public class ReferenceDTO { //for admin in dekanat

    public Long id;

    public String studentName;

    public String beginEducationDate;

    public String endEducationDate;

    public String admissionOrder;

    public String specialistName;

    public String organisation;

    public String speciality;

    public String groupNumber;

    //budget or pay
    public String type;

    //day or evening
    public String time;

    //first or second
    public String number;
}

