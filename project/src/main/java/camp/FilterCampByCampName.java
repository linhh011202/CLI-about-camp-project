package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class FilterCampByCampName implements IFilterCamps {
    private FilterManager filterManager;

    public FilterCampByCampName(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void filterCamps(String filterString) {
        ArrayList<Camp> allCamps = filterManager.getCampDataBase().getAllCamps();
        for (int i = 0; i < allCamps.size(); ++i) {
            // Set filtered marker on camps according to whether they match the campName or
            // not.
            if (allCamps.get(i).getCampName().equals(filterString)) {
                allCamps.get(i).setIsFilteredOut(false);
            } else {
                allCamps.get(i).setIsFilteredOut(true);
            }
        }
    }

}