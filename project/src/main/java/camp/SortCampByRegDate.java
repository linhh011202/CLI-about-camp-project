package camp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/** 
 * Represents a class that looks within a camp database, and sorts all the camps by their registration closing date.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class SortCampByRegDate implements ISortCamps {
    /**
     * The sort manager that manages this SortCampByRegDate.
     */
    private SortManager sortManager;

    /**
     * Creates a new SortCampByRegDate with its associated sort manager.
     * @param sortManager This SortCampByRegDate's associated sort manager.
     */
    public SortCampByRegDate(SortManager sortManager) {
        this.sortManager = sortManager;
    }

    public void sortCamps() {
        // get all camps in database and sort.
        ArrayList<Camp> allCamps = sortManager.getCampDataBase().getAllCamps();

        Comparator<Camp> byCampName = Comparator.comparing(Camp::getRegClosingDate);
        // Sort the list using the custom Comparator
        Collections.sort(allCamps, byCampName);
    }
}
