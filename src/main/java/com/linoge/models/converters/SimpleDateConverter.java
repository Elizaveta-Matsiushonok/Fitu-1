package com.linoge.models.converters;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Timo on 13.01.2017.
 */
public final class SimpleDateConverter {

    private static final String SIMPLE_DATE_PATTERN = "yyyy-MM-dd";

    private SimpleDateConverter() {
    }

    public static String getSimpleFormatDate(Date date) {
        return new SimpleDateFormat(SIMPLE_DATE_PATTERN)
                .format(date);
    }
}
