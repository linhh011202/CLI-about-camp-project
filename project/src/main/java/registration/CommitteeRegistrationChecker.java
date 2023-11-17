package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class CommitteeRegistrationChecker implements ICheckRegistration {
     /**
     * This CommitteeCampRegisterer's associated registration database.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * Creates a new CommitteeRegistrationChecker with the registration database that it manages. The registration database will 
     * call this constructor and input itself as the paramter upon initialisation, or if not, a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This CommitteeRegistrationChecker's associated registration database.
     */
    public CommitteeRegistrationChecker(RegistrationDataBase registrationDataBase) {
        this.registrationDataBase = registrationDataBase;
    }

    public boolean checkRegistration(String studentName, String campName) {
        ArrayList<Registration> allRegistrations = registrationDataBase.getAllRegistrations();
        // Check all registrations for corresponding student name and campname as camp
        // Committee, and not dereged. Return true once found.
        // If not, student doesnt exist in that camp as Commitee. Return false.
        for (int i = 0; i < allRegistrations.size(); ++i) {
            if (allRegistrations.get(i).getStudentName().equals(studentName)
                    && allRegistrations.get(i).getCampName().equals(campName)
                    && allRegistrations.get(i).getRole().equals("Camp Committee")
                    && !allRegistrations.get(i).getDeregistered()) {
                return true;
            }
        }
        return false;
    }
}
