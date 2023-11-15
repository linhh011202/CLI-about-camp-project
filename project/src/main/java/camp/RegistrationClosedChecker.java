package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.time.LocalDate;

public class RegistrationClosedChecker implements ICheckRegistrationClosed {
    private CampDataBase campDataBase;

    public RegistrationClosedChecker(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public boolean isRegistrationClosed(String campName) {
        for (int i = 0; i < campDataBase.getAllCamps().size(); ++i) {
            if (campDataBase.getAllCamps().get(i).getCampName().equals(campName)) {
                // return true if registration is closed, else return false
                if (campDataBase.getAllCamps().get(i).getRegClosingDate().isBefore(LocalDate.now())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
