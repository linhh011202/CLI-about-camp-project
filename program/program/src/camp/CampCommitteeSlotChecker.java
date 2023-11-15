package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class CampCommitteeSlotChecker implements IGetCampSlots {
    private CampDataBase campDataBase;

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
