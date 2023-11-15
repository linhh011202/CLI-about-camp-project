package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortCampByStaffIC implements ISortCamps {
    private SortManager sortManager;

    SortCampByStaffIC(SortManager sortManager) {
        this.sortManager = sortManager;
    }

    public void sortCamps() {
        // get all camps in database and sort.
        ArrayList<Camp> allCamps = sortManager.getCampDataBase().getAllCamps();

        Comparator<Camp> byCampName = Comparator.comparing(Camp::getStaffInCharge);
        // Sort the list using the custom Comparator
        Collections.sort(allCamps, byCampName);
    }
}