package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that helps to reduce the available Camp Committee Slot for a camp in this object's associated Camp Database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CampCommitteeSlotReducer implements IReduceCampSlots {
    /**
     * The Camp Database that this CampCommitteeSlotChecker manages.
     */
    private CampDataBase campDataBase;

     /**
     * Creates a new CampCommitteeSlotReducer with the given Camp Database.
     * @param campDataBase This CampCommitteeSlotReducer's associated Camp Database.
     */
    public CampCommitteeSlotReducer(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public void reduceCampSlots(String campName) {
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        // Search camps for campName to reduce camp slot for that camp. Should be able
        // to find, since called by Registerer who shd error check
        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getCampName().equals(campName)) {
                Camp campToEdit = allCamps.get(i);
                // Reduce available committee slots by 1.
                campToEdit.setAvailableCampComSlots(campToEdit.getAvailableCampComSlots() - 1);
                return;
            }
        }
    }
}
