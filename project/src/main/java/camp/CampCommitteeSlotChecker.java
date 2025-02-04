package camp;

import misc.*;


import java.util.ArrayList;

/** 
 * Represents a class that helps to check the remaining Camp Committee Slot for a camp in this object's associated Camp Database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CampCommitteeSlotChecker implements IGetCampSlots {

    /**
     * The Camp Database that this CampCommitteeSlotChecker manages.
     */
    private CampDataBase campDataBase;

    
    /**
     * Creates a new CampCommitteeSlotChecker with the given Camp Database.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This CampCommitteeSlotChecker's associated Camp Database.
     */
    public CampCommitteeSlotChecker(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public int getCampSlots(String campName) {
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        // Search camps for campName to check and return slots. If no slots, return
        // error code. If no camp, return error code.
        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getCampName().equals(campName)) {
                if (allCamps.get(i).getAvailableCampComSlots() <= 0) {
                    return IntErrorCodes.INSUFFICIENT_COMMITTEE_SLOTS;
                } else
                    return allCamps.get(i).getAvailableCampComSlots();
            }
        }
        return IntErrorCodes.CAMP_NOT_FOUND;
    }
}
