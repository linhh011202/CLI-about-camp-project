package camp;

import registration.*;

/** 
 * Represents a class that manages all the various types of filters. These filters can be obtained from the FilterManager, and
 * utilised as interfaces by the user classes.
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class FilterManager {
    //Student shouldnt have access to interfaces for filters that he shouldn't be able to know. Like attendeename, etc.
    /**
     * This FilterManager's associated Camp database.
     */
    private CampDataBase campDataBase;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by camp name.
     */
    private FilterCampByCampName filterCampByCampName;

    /**
     * This FilterManager's class that implements an interface to allow clients to not filter out any camps within the camp database.
     */
    private FilterCampByNothing filterCampByNothing;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by start date.
     */
    private FilterCampByStartDate filterCampByStartDate;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by end date.
     */
    private FilterCampByEndDate filterCampByEndDate;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by registration closing date.
     */
    private FilterCampByRegClosingDate filterCampByRegClosingDate;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by visibility status.
     */
    private FilterCampByVisibility filterCampByVisibility;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by location.
     */
    private FilterCampByLocation filterCampByLocation;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by total overall slots.
     */
    private FilterCampByTotalSlots filterCampByTotalSlots;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by total camp attendee slots.
     */
    private FilterCampByAttendeeSlots filterCampByAttendeeSlots;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by total camp committee slots.
     */
    private FilterCampByCampComSlots filterCampByCampComSlots;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by  remaining available camp committee slots.
     */
    private FilterCampByAvailableCampComSlots filterCampByAvailableCampComSlots;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by remaining available attendee slots.
     */
    private FilterCampByAvailableAttendeeSlots filterCampByAvailableAttendeeSlots;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by the name of the staff in charge.
     */
    private FilterCampByStaffIC filterCampByStaffIC;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by the name of the faculty that it is open to.
     */
    private FilterCampByOpenTo filterCampByOpenTo;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by the presence of a student as an attendee of that camp.
     */
    private FilterCampByAttendeeName filterCampByAttendeeName;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by the presence of a student as a camp committee member of that camp.
     */
    private FilterCampByCommitteeName filterCampByCommitteeName;

    /**
     * This FilterManager's class that implements an interface to allow clients to filter all the camps within the camp database
     * by the camp's description.
     */
    private FilterCampByDescription filterCampByDescription;


    /**
     * Creates a new FilterManager that initialises all the associated filter classes that will be used by clients as interfaces. 
     * It is created with the camp database it is associated with and will filter the camps in, and the neccessary interfaces from 
     * registration database class that some of the filtering mechanisms require.
     * @param campDataBase This FilterManager's associated camp database.
     * @param attendeeRegistrationChecker Interface from Registration database that checks if a student is registered as a camp attendee in a camp.
     * @param committeeRegistrationChecker Interface from Registration database that checks if a student is registered as a camp committee in a camp.
     */
    public FilterManager(CampDataBase campDataBase, ICheckRegistration attendeeRegistrationChecker,
            ICheckRegistration committeeRegistrationChecker) {
        this.campDataBase = campDataBase;
        this.filterCampByCampName = new FilterCampByCampName(this);
        this.filterCampByNothing = new FilterCampByNothing(this);
        this.filterCampByStartDate = new FilterCampByStartDate(this);
        this.filterCampByEndDate = new FilterCampByEndDate(this);
        this.filterCampByRegClosingDate = new FilterCampByRegClosingDate(this);
        this.filterCampByVisibility = new FilterCampByVisibility(this);
        this.filterCampByLocation = new FilterCampByLocation(this);
        this.filterCampByTotalSlots = new FilterCampByTotalSlots(this);
        this.filterCampByAttendeeSlots = new FilterCampByAttendeeSlots(this);
        this.filterCampByCampComSlots = new FilterCampByCampComSlots(this);
        this.filterCampByAvailableCampComSlots = new FilterCampByAvailableCampComSlots(this);
        this.filterCampByAvailableAttendeeSlots = new FilterCampByAvailableAttendeeSlots(this);
        this.filterCampByStaffIC = new FilterCampByStaffIC(this);
        this.filterCampByOpenTo = new FilterCampByOpenTo(this);
        this.filterCampByDescription = new FilterCampByDescription(this);
        this.filterCampByAttendeeName = new FilterCampByAttendeeName(this, attendeeRegistrationChecker);
        this.filterCampByCommitteeName = new FilterCampByCommitteeName(this, committeeRegistrationChecker);
    }

    /**
     * Gets this FilterManager's associated camp database.
     * @return This FilterManager's camp database that it is filtering.
     */
    public CampDataBase getCampDataBase() {
        return campDataBase;
    }

    /**
     * Gets this FilterManager's FilterCampByCampName object.
     * @return This FilterManager's FilterCampByCampName object.
     */
    public FilterCampByCampName getFilterCampByCampName() {
        return filterCampByCampName;
    }

    /**
     * Gets this FilterManager's FilterCampByNothing object.
     * @return This FilterManager's FilterCampByNothing object.
     */
    public FilterCampByNothing getFilterCampByNothing() {
        return filterCampByNothing;
    }

    /**
     * Gets this FilterManager's FilterCampByStartDate object.
     * @return This FilterManager's FilterCampByStartDate object.
     */
    public FilterCampByStartDate getFilterCampByStartDate() {
        return filterCampByStartDate;
    }

    /**
     * Gets this FilterManager's FilterCampByEndDate object.
     * @return This FilterManager's FilterCampByEndDate object.
     */
    public FilterCampByEndDate getFilterCampByEndDate() {
        return filterCampByEndDate;
    }

    /**
     * Gets this FilterManager's FilterCampByRegClosingDate object.
     * @return This FilterManager's FilterCampByRegClosingDate object.
     */
    public FilterCampByRegClosingDate getFilterCampByRegClosingDate() {
        return filterCampByRegClosingDate;
    }

    /**
     * Gets this FilterManager's FilterCampByVisibility object.
     * @return This FilterManager's FilterCampByVisibility object.
     */
    public FilterCampByVisibility getFilterCampByVisibility() {
        return filterCampByVisibility;
    }

    /**
     * Gets this FilterManager's FilterCampByLocation object.
     * @return This FilterManager's FilterCampByLocation object.
     */
    public FilterCampByLocation getFilterCampByLocation() {
        return filterCampByLocation;
    }

    /**
     * Gets this FilterManager's FilterCampByTotalSlots object.
     * @return This FilterManager's FilterCampByTotalSlots object.
     */
    public FilterCampByTotalSlots getFilterCampByTotalSlots() {
        return filterCampByTotalSlots;
    }

    /**
     * Gets this FilterManager's FilterCampByAttendeeSlots object.
     * @return This FilterManager's FilterCampByAttendeeSlots object.
     */
    public FilterCampByAttendeeSlots getFilterCampByAttendeeSlots() {
        return filterCampByAttendeeSlots;
    }

    /**
     * Gets this FilterManager's FilterCampByCampComSlots object.
     * @return This FilterManager's FilterCampByCampComSlots object.
     */
    public FilterCampByCampComSlots getFilterCampByCampComSlots() {
        return filterCampByCampComSlots;
    }

    /**
     * Gets this FilterManager's FilterCampByAvailableCampComSlots object.
     * @return This FilterManager's FilterCampByAvailableCampComSlots object.
     */
    public FilterCampByAvailableCampComSlots getFilterCampByAvailableCampComSlots() {
        return filterCampByAvailableCampComSlots;
    }

    /**
     * Gets this FilterManager's FilterCampByAvailableAttendeeSlots object.
     * @return This FilterManager's FilterCampByAvailableAttendeeSlots object.
     */
    public FilterCampByAvailableAttendeeSlots getFilterCampByAvailableAttendeeSlots() {
        return filterCampByAvailableAttendeeSlots;
    }

    /**
     * Gets this FilterManager's FilterCampByStaffIC object.
     * @return This FilterManager's FilterCampByStaffIC object.
     */
    public FilterCampByStaffIC getFilterCampByStaffIC() {
        return filterCampByStaffIC;
    }

    /**
     * Gets this FilterManager's FilterCampByOpenTo object.
     * @return This FilterManager's FilterCampByOpenTo object.
     */
    public FilterCampByOpenTo getFilterCampByOpenTo() {
        return filterCampByOpenTo;
    }

    /**
     * Gets this FilterManager's FilterCampByAttendeeName object.
     * @return This FilterManager's FilterCampByAttendeeName object.
     */
    public FilterCampByAttendeeName getFilterCampByAttendeeName() {
        return filterCampByAttendeeName;
    }

    /**
     * Gets this FilterManager's FilterCampByCommitteeName object.
     * @return This FilterManager's FilterCampByCommitteeName object.
     */
    public FilterCampByCommitteeName getFilterCampByCommitteeName() {
        return filterCampByCommitteeName;
    }

    /**
     * Gets this FilterManager's FilterCampByDescription object.
     * @return This FilterManager's FilterCampByDescription object.
     */
    public FilterCampByDescription getFilterCampByDescription() {
        return filterCampByDescription;
    }

}
