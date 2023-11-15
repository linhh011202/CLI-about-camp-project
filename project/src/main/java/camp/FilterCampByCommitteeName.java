package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class FilterCampByCommitteeName implements IFilterCamps {
    private FilterManager filterManager;
    private ICheckRegistration committeeRegistrationChecker;

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
