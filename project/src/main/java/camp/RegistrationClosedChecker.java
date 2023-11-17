package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.time.LocalDate;

/** 
 * Represents an class that checks within a camp database if a specific camp's registration closing date has passed.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class RegistrationClosedChecker implements ICheckRegistrationClosed {
    /**
     * The Camp Database that this RegistrationClosedChecker manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new RegistrationClosedChecker with the given Camp Database.
     * @param campDataBase This RegistrationClosedChecker's associated Camp Database.
     */
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
