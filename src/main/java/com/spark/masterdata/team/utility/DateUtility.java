package com.spark.masterdata.team.utility;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtility {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    public static String convertDateString(OffsetDateTime input) {
        return input.format(DATE_FORMAT);
    }

    /**
     * Method to convert String to OffsetDate time <br>
     * Sample value <b>2018-05-19T16:38:45.494+05:30</b>
     * 
     * @return {@link OffsetDateTime}
     */
    public static OffsetDateTime convertStringDate(String input) {
        return OffsetDateTime.parse(input, DATE_FORMAT);
    }
}
