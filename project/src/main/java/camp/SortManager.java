package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

/** 
 * Represents a class that manages all the various types of sorters. These sorters can be obtained from the SortManager, and
 * utilised as interfaces by the user classes to sort the camps before calling their viewing/generating report functions.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/

public class SortManager {
    /**
     * This SortManager's associated Camp database
     */
    private CampDataBase campDataBase;

    /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by camp name.
     */
    private SortCampByCampName sortCampByCampName;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by camp start date.
     */
    private SortCampByStartDate sortCampByStartDate;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by camp end date.
     */
    private SortCampByEndDate sortCampByEndDate;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by camp registration date.
     */
    private SortCampByRegDate sortCampByRegDate;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by camp visibility status.
     */
    private SortCampByVisibility sortCampByVisibility;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by camp location.
     */
    private SortCampByLocation sortCampByLocation;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by camp total slots.
     */
    private SortCampByTotalSlots sortCampByTotalSlots;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by total camp committee slots.
     */
    private SortCampByCampComSlots sortCampByCampComSlots;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by camp description.
     */
    private SortCampByDescription sortCampByDescription;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by the camp's staff-in-charge name.
     */
    private SortCampByStaffIC sortCampByStaffIC;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by the name of faculty that the camp is open to.
     */
    private SortCampByOpenTo sortCampByOpenTo;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by the total number of attendee slots.
     */
    private SortCampByAttendeeSlots sortCampByAttendeeSlots;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by the remaining available attendee slots.
     */
    private SortCampByAvailableAttendeeSlots sortCampByAvailableAttendeeSlots;

     /**
     * This SortManager's class that implements an interface to allow clients to sort all the camps within the camp database
     * by the remaining available camp committee slots.
     */
    private SortCampByAvailableCampCommiteeSlots sortCampByAvailableCampCommiteeSlots;

    /**
     * Creates a new SortManager that initialises all the associated sorting classes that will be used by clients as interfaces
     * to sort the camps in the camp database object that is associated to the sort manager.
     * @param campDataBase This SortManager's associated camp database.
     */
    public SortManager(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
        this.sortCampByCampName = new SortCampByCampName(this);
        this.sortCampByStartDate = new SortCampByStartDate(this);
        this.sortCampByEndDate = new SortCampByEndDate(this);
        this.sortCampByRegDate = new SortCampByRegDate(this);
        this.sortCampByVisibility = new SortCampByVisibility(this);
        this.sortCampByLocation = new SortCampByLocation(this);
        this.sortCampByTotalSlots = new SortCampByTotalSlots(this);
        this.sortCampByCampComSlots = new SortCampByCampComSlots(this);
        this.sortCampByDescription = new SortCampByDescription(this);
        this.sortCampByStaffIC = new SortCampByStaffIC(this);
        this.sortCampByOpenTo = new SortCampByOpenTo(this);
        this.sortCampByAttendeeSlots = new SortCampByAttendeeSlots(this);
        this.sortCampByAvailableAttendeeSlots = new SortCampByAvailableAttendeeSlots(this);
        this.sortCampByAvailableCampCommiteeSlots = new SortCampByAvailableCampCommiteeSlots(this);
    }

    // Getters for these classes so User class can set their sorts as these guys,
    // and pass the param to the ViewCamps interface call
    // these will be upcast back as interface when placed in user class.


    
    /**
     * Gets this SortManager's SortCampByCampName object.
     * @return This SortManager's SortCampByCampName object.
     */
    public SortCampByCampName getSortCampByCampName() {
        return sortCampByCampName;
    }

     /**
     * Gets this SortManager's SortCampByStartDate object.
     * @return This SortManager's SortCampByStartDate object.
     */
    public SortCampByStartDate getSortCampByStartDate() {
        return sortCampByStartDate;
    }

     /**
     * Gets this SortManager's SortCampByEndDate object.
     * @return This SortManager's SortCampByEndDate object.
     */
    public SortCampByEndDate getSortCampByEndDate() {
        return sortCampByEndDate;
    }

     /**
     * Gets this SortManager's SortCampByRegDate object.
     * @return This SortManager's SortCampByRegDate object.
     */
    public SortCampByRegDate getSortCampByRegDate() {
        return sortCampByRegDate;
    }

     /**
     * Gets this SortManager's SortCampByVisibility object.
     * @return This SortManager's SortCampByVisibility object.
     */
    public SortCampByVisibility getSortCampByVisibility() {
        return sortCampByVisibility;
    }

     /**
     * Gets this SortManager's SortCampByLocation object.
     * @return This SortManager's SortCampByLocation object.
     */
    public SortCampByLocation getSortCampByLocation() {
        return sortCampByLocation;
    }

     /**
     * Gets this SortManager's SortCampByTotalSlots object.
     * @return This SortManager's SortCampByTotalSlots object.
     */
    public SortCampByTotalSlots getSortCampByTotalSlots() {
        return sortCampByTotalSlots;
    }

     /**
     * Gets this SortManager's SortCampByCampComSlots object.
     * @return This SortManager's SortCampByCampComSlots object.
     */
    public SortCampByCampComSlots getSortCampByCampComSlots() {
        return sortCampByCampComSlots;
    }

     /**
     * Gets this SortManager's SortCampByDescription object.
     * @return This SortManager's SortCampByDescription object.
     */
    public SortCampByDescription getSortCampByDescription() {
        return sortCampByDescription;
    }

     /**
     * Gets this SortManager's SortCampByStaffIC object.
     * @return This SortManager's SortCampByStaffIC object.
     */
    public SortCampByStaffIC getSortCampByStaffIC() {
        return sortCampByStaffIC;
    }

     /**
     * Gets this SortManager's SortCampByOpenTo object.
     * @return This SortManager's SortCampByOpenTo object.
     */
    public SortCampByOpenTo getSortCampByOpenTo() {
        return sortCampByOpenTo;
    }

     /**
     * Gets this SortManager's SortCampByAttendeeSlots object.
     * @return This SortManager's SortCampByAttendeeSlots object.
     */
    public SortCampByAttendeeSlots getSortCampByAttendeeSlots() {
        return sortCampByAttendeeSlots;
    }

     /**
     * Gets this SortManager's SortCampByAvailableAttendeeSlots object.
     * @return This SortManager's SortCampByAvailableAttendeeSlots object.
     */
    public SortCampByAvailableAttendeeSlots getSortCampByAvailableAttendeeSlots() {
        return sortCampByAvailableAttendeeSlots;
    }

     /**
     * Gets this SortManager's SortCampByAvailableCampCommiteeSlots object.
     * @return This SortManager's SortCampByAvailableCampCommiteeSlots object.
     */
    public SortCampByAvailableCampCommiteeSlots getSortCampByAvailableCampCommiteeSlots() {
        return sortCampByAvailableCampCommiteeSlots;
    }

    /**
     * Gets this SortManager's associated camp database.
     * @return This SortManager's camp database that it is filtering.
     */
    public CampDataBase getCampDataBase() {
        return campDataBase;
    }
}
