package camp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortCampByAvailableCampCommiteeSlots implements ISortCamps {
    private SortManager sortManager;

    SortCampByAvailableCampCommiteeSlots(SortManager sortManager) {
        this.sortManager = sortManager;
    }

    public void sortCamps() {
        // get all camps in database and sort.
        ArrayList<Camp> allCamps = sortManager.getCampDataBase().getAllCamps();

        Comparator<Camp> byCampName = Comparator.comparing(Camp::getAvailableCampComSlots);
        // Sort the list using the custom Comparator
        Collections.sort(allCamps, byCampName);
    }
}
