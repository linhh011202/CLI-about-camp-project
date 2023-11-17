package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that helps to reduce the remaining camp attendee slots, given a camp name in the associated camp database. 
 * such as after registration of a student into the camp.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CampStudentSlotReducer implements IReduceCampSlots {
     /**
     * The Camp Database that this CampStudentSlotReducer manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new CampCommitteeSlotChecker with the given Camp Database.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This CampStudentSlotReducer's associated Camp Database.
     */
    public CampStudentSlotReducer(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public void reduceCampSlots(String campName) {
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        // Search camps for campName to reduce camp slot for that camp. Should be able
        // to find, since called by Registerer who shd error check
        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getCampName().equals(campName)) {
                Camp campToEdit = allCamps.get(i);
                // Reduce available attendee slots by 1.
                campToEdit.setAvailableAttendeeSlots(campToEdit.getAvailableAttendeeSlots() - 1);
                return;
            }
        }
    }
}
