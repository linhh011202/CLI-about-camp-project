package camp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortCampByCampComSlots implements ISortCamps {
    private SortManager sortManager;

    SortCampByCampComSlots(SortManager sortManager) {
        this.sortManager = sortManager;
    }

    public void sortCamps() {
        // get all camps in database and sort.
        ArrayList<Camp> allCamps = sortManager.getCampDataBase().getAllCamps();

        Comparator<Camp> byCampName = Comparator.comparing(Camp::getCampComSlots);
        // Sort the list using the custom Comparator
        Collections.sort(allCamps, byCampName);
    }
}
