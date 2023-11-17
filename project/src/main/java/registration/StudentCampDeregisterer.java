package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents an class that manages the registration database and allows clients to deregister from a camp.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StudentCampDeregisterer implements IDeregisterCamp {
     /**
     * This StudentCampDeregisterer's associated registration database.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * The interface this StudentCampDeregisterer uses to increment back the remaining number of attendeee slots in a camp upon
     * successful deregistration.
     */
    private IIncreaseCampSlots campStudentSlotIncreaser;

    /**
     * Creates a new StudentCampDeregisterer with the registration database that it manages, and the interface from
     * Camp database that it requires to increase the number of available camp attendee slots. The registration database will 
     * call this constructor and input itself as the paramter upon initialisation, or if not, a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This StudentCampDeregisterer's associated registration database.
     * @param campStudentSlotIncreaser Interface this StudentCampDeregisterer uses to increase available attendee slots.
     */
    public StudentCampDeregisterer(RegistrationDataBase registrationDataBase,
            IIncreaseCampSlots campStudentSlotIncreaser) {
        this.registrationDataBase = registrationDataBase;
        this.campStudentSlotIncreaser = campStudentSlotIncreaser;
    }

    public void deregisterCamp(Student student, String campName) {

        // Check if student is actually a campComm and is a campcomm of the camp he
        // wants to register for
        if (student instanceof CampCommittee) {
            if (((CampCommittee) student).getCampName().equals(campName)) {
                System.out.printf("Failed to deregister! You are a camp committee member of this camp.\n");
                return;
            }
        }

        // Finds the corresponding entry in the ArrayList. If not found, unable to
        // deregister.
        ArrayList<Registration> allRegistrations = registrationDataBase.getAllRegistrations();
        for (int i = 0; i < allRegistrations.size(); ++i) {
            // Find matching entry.
            if (allRegistrations.get(i).getStudentName().equals(student.getName())
                    && allRegistrations.get(i).getCampName().equals(campName)) {

                // Check if already deregistered
                if (allRegistrations.get(i).getDeregistered()) {
                    System.out.printf("You have already deregistered from this camp!\n");
                    return;
                }
                // Check if campCom
                if (allRegistrations.get(i).getRole().equals("Camp Committee")) {
                    System.out.printf(
                            "Deregistration failed! You are a camp committee member and cannot withdraw from this camp!\n");
                    return;
                }

                // Passed error checks, so we deregister student and increase back the available
                // slots.
                allRegistrations.get(i).setDeregistered(true);
                campStudentSlotIncreaser.increaseCampSlots(campName);
                System.out.printf("Successfully deregistered from camp! Camp name: %s\n",
                        allRegistrations.get(i).getCampName());
                return;
            }
        }

        System.out.printf("Deregistration failed! Unable to find records of you being registered for that camp!\n");
        return;
    }
}
