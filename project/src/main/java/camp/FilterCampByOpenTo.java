package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that helps to check if every camp in the database matches the faculty that it is open to as described in the given string,
 * and changes the isFilteredOut bit of that camp accordingly.
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class FilterCampByOpenTo implements IFilterCamps {
   /**
     * The filter manager that manages this FilterCampByOpenTo.
     */
    private FilterManager filterManager;

    /**
     * Creates a new FilterCampByOpenTo with its associated filter manager.
     * @param filterManager This FilterCampByOpenTo's associated filter manager.
     */
    public FilterCampByOpenTo(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void filterCamps(String filterString) {
        ArrayList<Camp> allCamps = filterManager.getCampDataBase().getAllCamps();
        for (int i = 0; i < allCamps.size(); ++i) {
            // Set filtered marker on camps according to whether they match the Faculty or
            // not.
            if (allCamps.get(i).getOpenTo().name().equals(filterString.toUpperCase())) {
                allCamps.get(i).setIsFilteredOut(false);
            } else {
                allCamps.get(i).setIsFilteredOut(true);
            }
        }
    }

}
