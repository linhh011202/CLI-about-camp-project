package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

/** 
 * Represents an interface to edit the details of a camp within a camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IEditCamp {
    /**
     * Changes the name of the camp.
     * @param user The user who wants to edit the camp
     * @param campName The name of the target camp.
     * @param newCampName The new camp name.
     * @return Implementors should return true on success and false on failure.
     */
    public boolean changeCampName(User user, String campName, String newCampName);

     /**
     * Changes the start date of the camp.
     * @param user The user who wants to edit the camp
     * @param campName The name of the target camp.
     * @param newStartDate The new start date.
     * @return Implementors should return true on success and false on failure.
     */
    public boolean changeStartDate(User user, String campName, String newStartDate);

    /**
     * Changes the end date of the camp.
     * @param user The user who wants to edit the camp
     * @param campName The name of the target camp.
     * @param newStartDate The new end date.
     * @return Implementors should return true on success and false on failure.
     */
    public boolean changeEndDate(User user, String campName, String newEndDate);

     /**
     * Changes the registration closing date of the camp.
     * @param user The user who wants to edit the camp
     * @param campName The name of the target camp.
     * @param newRegClosingDate The new registration closing date.
     * @return Implementors should return true on success and false on failure.
     */
    public boolean changeRegClosingDate(User user, String campName, String newRegClosingDate);

    /**
     * Changes the visibility status of the camp.
     * @param user The user who wants to edit the camp
     * @param campName The name of the target camp.
     * @param newVisibility The new visibility status.
     * @return Implementors should return true on success and false on failure.
     */
    public boolean changeVisibility(User user, String campName, boolean newVisibility);

    /**
     * Changes the location of the camp.
     * @param user The user who wants to edit the camp
     * @param campName The name of the target camp.
     * @param newLocation The new location.
     * @return Implementors should return true on success and false on failure.
     */
    public boolean changeLocation(User user, String campName, String newLocation);

    /**
     * Changes the total attendee slots of the camp.
     * @param user The user who wants to edit the camp
     * @param campName The name of the target camp.
     * @param newTotalSlots The new total attendee slots.
     * @return Implementors should return true on success and false on failure.
     */
    public boolean changeAttendeeSlots(User user, String campName, int newTotalSlots);

    /**
     * Changes the total camp committee slots of the camp.
     * @param user The user who wants to edit the camp
     * @param campName The name of the target camp.
     * @param newCampComSlots The new total camp committee slots.
     * @return Implementors should return true on success and false on failure.
     */
    public boolean changeCampComSlots(User user, String campName, int newCampComSlots);

    /**
     * Changes the description of the camp.
     * @param user The user who wants to edit the camp
     * @param campName The name of the target camp.
     * @param newDescription The new description.
     * @return Implementors should return true on success and false on failure.
     */

    public boolean changeDescription(User user, String campName, String newDescription);

    /*
     * DO WE ALLOW TO CHANGE WHO ITS OPEN TO?? what if alr registered then change
     * away.
     * public boolean changeOpenTo()
     * 
     * Also probably need error checks for many of this. Shd be allow editing once
     * people have signed up?
     */

}
