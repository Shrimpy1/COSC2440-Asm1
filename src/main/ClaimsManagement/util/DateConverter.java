/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utility class
 * Used for converting a String to a LocalDate object and vice versa
 * Used in writing & loading data, be cautious when changing format
 */
public class DateConverter {
    private static final String DATE_FORMAT = "yyyy-MM-dd"; // Format for the conversion
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    /**
     * Converts LocalDate to String. Must follow this class' format
     * @param date LocalDate object
     * @return String
     */
    public static String localDateToString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    /**
     * Converts String to LocalDate. Must follow this class' format
     * @param dateString String
     * @return LocalDate
     */
    public static LocalDate stringToLocalDate(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }


}
