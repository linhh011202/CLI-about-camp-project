package camp;

import java.util.ArrayList;

/** 
 * Represents a class that helps to check if every camp in the database matches the remaining camp committee slots as described in the given string,
 * and changes the isFilteredOut bit of that camp accordingly.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class FilterCampByAvailableCampComSlots implements IFilterCamps {
     /**
     * The filter manager that manages this FilterCampByAvailableCampComSlots.
     */
    private FilterManager filterManager;

    /**
     * Creates a new FilterCampByAvailableCampComSlots with its associated filter manager.
     * @param filterManager This FilterCampByAvailableCampComSlots's associated filter manager.
     */
    public FilterCampByAvailableCampComSlots(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void filterCamps(String filterString) {
        ArrayList<Camp> allCamps = filterManager.getCampDataBase().getAllCamps();
        for (int i = 0; i < allCamps.size(); ++i) {
            // Set filtered marker on camps according to whether they match or not.
            if (allCamps.get(i).getAvailableCampComSlots() == Integer.valueOf(filterString)) {
                allCamps.get(i).setIsFilteredOut(false);
            } else {
                allCamps.get(i).setIsFilteredOut(true);
            }
        }
    }

}
