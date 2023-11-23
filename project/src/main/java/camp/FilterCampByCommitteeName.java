package camp;

import registration.*;

import java.util.ArrayList;

/** 
 * Represents a class that helps to check if every camp in the database contains the student in the given string, and checks if
 * the student is a camp committee of that camp, then changes the isFilteredOut bit of that camp accordingly.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class FilterCampByCommitteeName implements IFilterCamps {
    /**
     * The filter manager that manages this FilterCampByCommitteeName.
     */
    private FilterManager filterManager;

    /**
     * The interface required from the registration database to filter camps by committee name.
     */
    private ICheckRegistration committeeRegistrationChecker;

     /**
     *  Creates a new FilterCampByCommitteeName with its associated filter manager, and required interface to utilise.
     * @param filterManager This FilterCampByCommitteeName's associated filter manager.
     * @param committeeRegistrationChecker The interface this FilterCampByCommitteeName needs to filter by camp committee name.
     */
    public FilterCampByCommitteeName(FilterManager filterManager, ICheckRegistration committeeRegistrationChecker) {
        this.filterManager = filterManager;
        this.committeeRegistrationChecker = committeeRegistrationChecker;
    }

    public void filterCamps(String filterString) {
        ArrayList<Camp> allCamps = filterManager.getCampDataBase().getAllCamps();
        for (int i = 0; i < allCamps.size(); ++i) {
            // Set filtered marker on camps according to whether there is said student in
            // camp or not.
            if (committeeRegistrationChecker.checkRegistration(filterString, allCamps.get(i).getCampName())) {
                allCamps.get(i).setIsFilteredOut(false);
            } else {
                allCamps.get(i).setIsFilteredOut(true);
            }

        }
    }

}
