package camp;

//NOT IN UMLYET

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils 
{
    //Converts string of format dd/mm/yyyy to a localDate struct! we can use that struct to compare 
    //between dates, and get current date.

    public static LocalDate stringToDate(String dateStr) {
        // You can add your date parsing logic here
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateStr,formatter);
    }

    //Converts date back to string for printing! 
    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}
