package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that will reset the isFilteredOut bits every time, hence ensuring that none of the camps are filtered out in the
 * associated camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class FilterCampByNothing implements IFilterCamps {
    /**
     * The filter manager that manages this FilterCampByNothing.
     */
    private FilterManager filterManager;

    /**
     * Creates a new FilterCampByNothing with its associated filter manager.
     * @param filterManager This FilterCampByNothing's associated filter manager.
     */
    public FilterCampByNothing(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void filterCamps(String filterString) {
        ArrayList<Camp> allCamps = filterManager.getCampDataBase().getAllCamps();
        // Since no filters, clears all filters and allows all to be seen.
        for (int i = 0; i < allCamps.size(); ++i) {
            allCamps.get(i).setIsFilteredOut(false);
        }
    }

}
