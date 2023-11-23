package misc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** 
 * Represents a class that provides static methods to convert String to LocalDate objects and vice versa.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class DateUtils {
    // Converts string of format dd/mm/yyyy to a localDate struct! we can use that
    // struct to compare
    // between dates, and get current date.

    /**
     * Takes in a String to output a corresponding LocalDate object.
     * @param dateStr The String to be converted to a LocalDate object. It should be in the format
     * DD/MM/YYYY.
     * @return The LocalDate Object created from the String.
     */
    public static LocalDate stringToDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * Takes in a LocalDate object to output a corresponding String objecct.
     * @param date The LocalDate object to be converted into a String.
     * @return The String object created from the LocalDate object. It is in the format DD/MM/YYYY.
     */
    // Converts date back to string for printing!
    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}
