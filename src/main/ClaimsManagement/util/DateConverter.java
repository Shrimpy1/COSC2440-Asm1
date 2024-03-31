/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static String localDateToString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    public static LocalDate stringToLocalDate(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }


}
