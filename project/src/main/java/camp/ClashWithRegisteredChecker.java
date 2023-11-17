package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;
import java.time.LocalDate;

/** 
 * Represents a class that helps to check if a camp from the associated camp database
 * clashes with any of a student's currently registered camps. 
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class ClashWithRegisteredChecker implements ICheckNoClash {
    /**
     * The Camp Database that this ClashWithRegisteredChecker manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new ClashWithRegisteredChecker with the given Camp Database.
     * @param campDataBase This ClashWithRegisteredChecker's associated Camp Database.
     */
    public ClashWithRegisteredChecker(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public boolean checkNoClash(ArrayList<String> campsRegistered, String campToRegister) {
        if (campsRegistered == null)
            return true;

        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        LocalDate campToRegisterStart = null;
        LocalDate campToRegisterEnd = null;

        // FindCamp he wants to register for.
        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getCampName().equals(campToRegister)) {
                campToRegisterStart = allCamps.get(i).getStartDate();
                campToRegisterEnd = allCamps.get(i).getEndDate();
            }
        }

        // Should never be able to happen, but just in case unable to find camp to be
        // registered in campDB
        if (campToRegisterEnd == null || campToRegisterEnd == null)
            return false;

        // In list of camps, find every registered camp.
        for (int i = 0; i < campsRegistered.size(); ++i) {
            for (int j = 0; j < allCamps.size(); ++j) {
                // found camp, validate dates dont clash.
                if (allCamps.get(j).getCampName().equals(campsRegistered.get(i))) {
                    if (allCamps.get(j).getStartDate().isAfter(campToRegisterEnd)
                            || campToRegisterStart.isAfter(allCamps.get(j).getEndDate())) {
                        // No overlap;
                    } else
                        return false;
                }
            }
        }
        return true;

    }

}
