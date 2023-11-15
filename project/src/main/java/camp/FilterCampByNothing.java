package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class FilterCampByNothing implements IFilterCamps {
    private FilterManager filterManager;

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
