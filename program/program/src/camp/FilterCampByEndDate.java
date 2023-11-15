package camp;

import java.util.ArrayList;

public class FilterCampByEndDate implements IFilterCamps {
    private FilterManager filterManager;

    public FilterCampByEndDate(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void filterCamps(String filterString) {
        ArrayList<Camp> allCamps = filterManager.getCampDataBase().getAllCamps();
        for (int i = 0; i < allCamps.size(); ++i) {
            // Set filtered marker on camps according to whether they match the campName or
            // not.
            if (DateUtils.dateToString(allCamps.get(i).getEndDate()).equals(filterString)) {
                allCamps.get(i).setIsFilteredOut(false);
            } else {
                allCamps.get(i).setIsFilteredOut(true);
            }
        }
    }

}
