package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class StudentViewAllCamps implements IViewAllCamps {
    private CampDataBase campDataBase;

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
