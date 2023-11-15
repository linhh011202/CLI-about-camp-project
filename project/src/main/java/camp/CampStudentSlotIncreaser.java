package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class CampStudentSlotIncreaser implements IIncreaseCampSlots {
    private CampDataBase campDataBase;

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
