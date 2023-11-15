package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class CampStudentSlotChecker implements IGetCampSlots {
    private CampDataBase campDataBase;

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
