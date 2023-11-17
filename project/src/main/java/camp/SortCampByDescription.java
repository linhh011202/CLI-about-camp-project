package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/** 
 * Represents a class that looks within a camp database, and sorts all the camps by their camp description.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class SortCampByDescription implements ISortCamps {
    /**
     * The sort manager that manages this SortCampByDescription.
     */
    private SortManager sortManager;

    /**
     * Creates a new SortCampByDescription with its associated sort manager.
     * @param sortManager This SortCampByDescription's associated sort manager.
     */
    SortCampByDescription(SortManager sortManager) {
        this.sortManager = sortManager;
    }

    public void sortCamps() {
        // get all camps in database and sort.
        ArrayList<Camp> allCamps = sortManager.getCampDataBase().getAllCamps();

        Comparator<Camp> byCampName = Comparator.comparing(Camp::getDescription);
        // Sort the list using the custom Comparator
        Collections.sort(allCamps, byCampName);
    }
}