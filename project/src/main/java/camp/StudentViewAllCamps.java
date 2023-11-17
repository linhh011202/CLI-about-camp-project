package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;


/** 
 * Represents a class that looks within it's associated camp database and prints all camp details that the student is allowed to see.
 * Currently, it is all camps that are open to his faculty, and visibility set to true.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StudentViewAllCamps implements IViewAllCamps {
    /**
     * The Camp Database that this StudentViewAllCamps manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new StudentViewAllCamps with the given Camp Database.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This StudentViewAllCamps's associated Camp Database.
     */

    public StudentViewAllCamps(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public void viewAllCamps(User user, ISortCamps iSortCamps, IFilterCamps iFilterCamps, String filterString) {
        iSortCamps.sortCamps();//// Sorts camps according to sorting set by user.
        iFilterCamps.filterCamps(filterString);// Set filter bits accordingly

        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        System.out.println("List of all camps visible to you:\n");

        boolean noCamps = true;
        for (int i = 0; i < allCamps.size(); ++i) {
            Camp curCamp = allCamps.get(i);

            // Could use an instanceOf operator here to check the downcasting below but the
            // code is so long alr TT
            // Only shows camps that are visible, AND within the student's faculty/NTU.
            // Also ensures it shows what is filtered.
            if (curCamp.getVisibility()) {
                if (curCamp.getOpenTo() == Faculty.NTU || (curCamp.getOpenTo() == (((Student) user).getFaculty()))) {
                    if (!curCamp.getIsFilteredOut()) {
                        curCamp.printCamp();
                        noCamps = false;
                    }
                }
            }
        }
        if (noCamps) {
            System.out.printf("There are no camps to display!\n");
        }
    }
}
