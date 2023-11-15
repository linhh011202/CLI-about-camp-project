package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class CampCommitteeSlotReducer implements IReduceCampSlots {
    private CampDataBase campDataBase;

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
