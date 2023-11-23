package registration;

import misc.*;
import java.util.ArrayList;

/** 
 * Represents a class that helps to check if a student is registered as an attendee in a given camp.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class AttendeeRegistrationChecker implements ICheckRegistration {
    /**
     * THe registration database that this AttendeeRegistrationChecker is managing.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * Creates a new AttendeeRegistrationChecker with its associated registration database.
     * This constructor should be called and AttendeeRegistrationChecker should be created automatically upon instantiation of
     * a {@link RegistrationDataBase}, or if not, a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This AttendeeRegistrationChecker's associated registration database.
     */
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
