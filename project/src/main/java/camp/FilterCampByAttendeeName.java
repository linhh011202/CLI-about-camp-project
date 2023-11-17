package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that helps to check if every camp in the database matches the Attendee Name described in the given string,
 * and changes the isFilteredOut bit of that camp accordingly.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class FilterCampByAttendeeName implements IFilterCamps {
    /**
     * The filter manager that manages this FilterCampByAttendeeName.
     */
    private FilterManager filterManager;
    /**
     * The interface required from the registration database to filter camps by attendee name.
     */
    private ICheckRegistration attendeeRegistrationChecker;

    /**
     *  Creates a new FilterCampByAttendeeName with its associated filter manager, and required interface to utilise.
     * @param filterManager This FilterCampByAttendeeName's associated filter manager.
     * @param attendeeRegistrationChecker The interface this FilterCampByAttendeeName needs to filter by camp attendee name.
     */
    public FilterCampByAttendeeName(FilterManager filterManager, ICheckRegistration attendeeRegistrationChecker) {
        this.filterManager = filterManager;
        this.attendeeRegistrationChecker = attendeeRegistrationChecker;
    }

    public void filterCamps(String filterString) {
        ArrayList<Camp> allCamps = filterManager.getCampDataBase().getAllCamps();
        for (int i = 0; i < allCamps.size(); ++i) {
            // Set filtered marker on camps according to whether there is said student in
            // camp or not.
            if (attendeeRegistrationChecker.checkRegistration(filterString, allCamps.get(i).getCampName())) {
                allCamps.get(i).setIsFilteredOut(false);
            } else {
                allCamps.get(i).setIsFilteredOut(true);
            }

        }
    }

}
