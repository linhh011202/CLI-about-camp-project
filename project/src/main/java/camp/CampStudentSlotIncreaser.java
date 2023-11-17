package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that helps to increase the remaining camp attendee slots of a camp, given the camp name,
 * such as after deregistration/withdrawal of a student from the camp, from the associated camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CampStudentSlotIncreaser implements IIncreaseCampSlots {
    /**
     * The Camp Database that this CampStudentSlotIncreaser manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new CampCommitteeSlotChecker with the given Camp Database.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This CampStudentSlotIncreaser's associated Camp Database.
     */
    public CampStudentSlotIncreaser(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public void increaseCampSlots(String campName) {
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        // Search camps for campName to increase camp slot for that camp. Should be able
        // to find, since called by Registerer who shd error check and only call this if
        // matching entry is found.
        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getCampName().equals(campName)) {
                Camp campToEdit = allCamps.get(i);
                // Increase available attendee slots by 1.
                campToEdit.setAvailableAttendeeSlots(campToEdit.getAvailableAttendeeSlots() + 1);
                return;
            }
        }
    }
}
