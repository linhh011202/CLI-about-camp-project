package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

/** 
 * Represents an interface to create a camp within a camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface ICreateCamp {
    /**
     * Creates a new camp to be stored within the associated camp database. This camp is created with camp name, start date,
     * end date, registration closing date, initial visibility status, location, number of attendee slots, number of camp committee slots,
     * description, the user object that is creating it, and the faculty that the camp is open to.
     * 
     * @param campName The Camp's camp name.
     * @param startDate The Camp's start date.
     * @param endDate The Camp's end date.
     * @param regClosingDate The Camp's registration closing date.
     * @param visibility The Camp's visibility status.
     * @param location The Camp's location
     * @param attendeeSlots The Camp's number of attendee slots.
     * @param campComSlots The Camp's number of camp committee slots.
     * @param description The Camp's description.
     * @param user The user who is creating the camp.
     * @param openTo The Camp's faculty that it is open to.
     */
    public void createCamp(String campName, String startDate, String endDate, String regClosingDate, boolean visibility,
            String location, int attendeeSlots, int campComSlots, String description, User user, Faculty openTo);
}
