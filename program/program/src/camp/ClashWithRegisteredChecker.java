package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;
import java.time.LocalDate;

public class ClashWithRegisteredChecker implements ICheckNoClash {
    private CampDataBase campDataBase;

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
