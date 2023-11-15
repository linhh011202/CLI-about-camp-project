package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class AttendeeRegistrationChecker implements ICheckRegistration {
    private RegistrationDataBase registrationDataBase;

    public AttendeeRegistrationChecker(RegistrationDataBase registrationDataBase) {
        this.registrationDataBase = registrationDataBase;
    }

    public boolean checkRegistration(String studentName, String campName) {
        ArrayList<Registration> allRegistrations = registrationDataBase.getAllRegistrations();
        // Check all registrations for corresponding student name and campname as camp
        // attendee, and not dereged. Return true once found.
        // If not, student doesnt exist in that camp as attendee. Return false.
        for (int i = 0; i < allRegistrations.size(); ++i) {
            if (allRegistrations.get(i).getStudentName().equals(studentName)
                    && allRegistrations.get(i).getCampName().equals(campName)
                    && allRegistrations.get(i).getRole().equals("Camp Attendee")
                    && !allRegistrations.get(i).getDeregistered()) {
                return true;
            }
        }
        return false;
    }
}
