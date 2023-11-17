package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that helps to check the remaining camp attendee slots of a camp, given the camp name in the associated camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CampStudentSlotChecker implements IGetCampSlots {
    /**
     * The Camp Database that this CampCommitteeSlotChecker manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new CampStudentSlotChecker with the given Camp Database.
     * @param campDataBase This CampStudentSlotChecker's associated Camp Database.
     */
    public CampStudentSlotChecker(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public int getCampSlots(String campName) {
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        // Search camps for campName to check and return slots. If no slots, return
        // error code. If no camp, return error code.
        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getCampName().equals(campName)) {
                if (allCamps.get(i).getAvailableAttendeeSlots() <= 0) {
                    return IntErrorCodes.INSUFFICIENT_STUDENT_SLOTS;
                } else
                    return allCamps.get(i).getAvailableAttendeeSlots();
            }
        }
        return IntErrorCodes.CAMP_NOT_FOUND;
    }
}
