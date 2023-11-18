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
 * Represents a class that looks within a camp database, and sorts all the camps by the name of the faculty they are open to.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class SortCampByOpenTo implements ISortCamps {
   /**
     * The sort manager that manages this SortCampByOpenTo.
     */
    private SortManager sortManager;

    /**
     * Creates a new SortCampByOpenTo with its associated sort manager.
     * @param sortManager This SortCampByOpenTo's associated sort manager.
     */
    public SortCampByOpenTo(SortManager sortManager) {
        this.sortManager = sortManager;
    }

    public void sortCamps() {
        // get all camps in database and sort.
        ArrayList<Camp> allCamps = sortManager.getCampDataBase().getAllCamps();

        Comparator<Camp> byCampName = Comparator.comparing(Camp::getStringOpenTo);
        // Sort the list using the custom Comparator
        Collections.sort(allCamps, byCampName);
    }
}