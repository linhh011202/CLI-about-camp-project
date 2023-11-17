package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents an class that manages the registration database and allows clients to register for a camp as a camp attendee.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StudentCampRegisterer implements IRegisterCamp {
    /**
     * This StudentCampRegisterer's associated registration database.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * An interface used by StudentCampRegisterer to check if there are still available camp attendee slots in the camp.
     */
    private IGetCampSlots campStudentSlotChecker;

    /**
     * An interface used by StudentCampRegisterer to reduce the remaining number of camp committee slots upon successful registration
     * of the student as camp attendee.
     */

    private IReduceCampSlots campStudentSlotReducer;

    /**
     * An interface used by StudentCampRegisterer to check if the camp's faculty is open to the student.
     */
    private ICheckSchoolMatch checkSchoolMatch;


    /**
     * An interface used by StudentCampRegisterer to obtain the list of camps a student has already registered for. 
     */
    private IGetCampsRegistered registeredCampNamesGetter;


    /**
     * An interface used by StudentCampRegisterer to check if the camp that a student wants to register for clashes with
     * his already registered camps.
     */
    private ICheckNoClash clashWithRegisteredChecker;


    /**
     * An interface used by StudentCampRegisterer to check if the camp's registration deadline has passed.
     */
    private ICheckRegistrationClosed registrationClosedChecker;

    /**
     * An interface used by StudentCampRegisterer to check if the camp is even visible to the student, to be allowed to register.
     */
    private ICheckCampVisibility campvisibilityChecker;

    /**
     * Creates a new StudentCampRegisterer with its associated registration database and interfaces required to 
     * perform its method functions successfully. These interfaces are obtained from the CampDataBase and this constructor should
     * automatically be called upon the creation of a {@link RegistrationDataBase} or if not, after using the static method from {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This StudentCampRegisterer's associated registration database.
     * @param campStudentSlotChecker An interface used by StudentCampRegisterer to check if there are still available camp attendee slots in the camp.
     * @param campStudentSlotReducer An interface used by StudentCampRegisterer to check if the camp's faculty is open to the student.
     * @param checkSchoolMatch An interface used by StudentCampRegisterer to check if the camp's faculty is open to the student.
     * @param clashWithRegisteredChecker An interface used by StudentCampRegisterer to check if the camp that a student wants to register for clashes with
     * his already registered camps.
     * @param registrationClosedChecker An interface used by StudentCampRegisterer to check if the camp's registration deadline has passed.
     * @param registeredCampNamesGetter An interface used by StudentCampRegisterer to obtain the list of camps a student has already registered for.
     * @param campvisibilityChecker An interface used by StudentCampRegisterer to check if the camp is even visible to the student, to be allowed to register.
     */
    public StudentCampRegisterer(RegistrationDataBase registrationDataBase, IGetCampSlots campStudentSlotChecker,
            IReduceCampSlots campStudentSlotReducer, ICheckSchoolMatch checkSchoolMatch,
            ICheckNoClash clashWithRegisteredChecker, ICheckRegistrationClosed registrationClosedChecker,
            RegisteredCampNamesGetter registeredCampNamesGetter, ICheckCampVisibility campvisibilityChecker) {
        this.registrationDataBase = registrationDataBase;
        this.campStudentSlotChecker = campStudentSlotChecker;
        this.campStudentSlotReducer = campStudentSlotReducer;
        this.checkSchoolMatch = checkSchoolMatch;
        this.registeredCampNamesGetter = registeredCampNamesGetter;
        this.clashWithRegisteredChecker = clashWithRegisteredChecker;
        this.registrationClosedChecker = registrationClosedChecker;
        this.campvisibilityChecker = campvisibilityChecker;
    }

    public void registerCamp(Student student, String campName) {

        // Check if camp is even visible to student, or exists.
        boolean returnVal = campvisibilityChecker.isCampVisible(campName);
        if (!returnVal)// means Camp isn't visible. Error message printed by campVisibilityChecker
        {
            return;
        }
        // Error checks if the camp is open to the student
        returnVal = checkSchoolMatch.checkSchoolMatch(student, campName);
        if (!returnVal)// means mismatch occured, or school doesn't exist. Error message printed by
                       // checkSchoolMatch.
        {
            return;
        }

        // Check existing registration database if student has already registered, or
        // has deregistered before.
        ArrayList<Registration> allRegistrations = registrationDataBase.getAllRegistrations();
        for (int i = 0; i < allRegistrations.size(); ++i) {
            if (allRegistrations.get(i).getCampName().equals(campName)
                    && allRegistrations.get(i).getStudentName().equals(student.getName())) {
                if (allRegistrations.get(i).getDeregistered()) {
                    System.out.println(
                            "Failed to register. You have deregistered from this camp before! Unable to register again.");
                } else {
                    System.out.println("Failed to register. You are already registered for this camp!");
                }
                return;
            }
        }

        // Checks if past register closing date.
        if (registrationClosedChecker.isRegistrationClosed(campName)) {
            System.out.println("Failed to register. Registration has already been closed!");
            return;
        }

        // Checks if dates clash
        ArrayList<String> allRegisteredCamps = registeredCampNamesGetter.getRegisteredCampNames(student.getName());
        if (!clashWithRegisteredChecker.checkNoClash(allRegisteredCamps, campName)) {
            System.out.println("Failed to register. Dates clash with existing registered camp!");
            return;
        }

        // uses Interface from campDB to check to see if camp has enough REGULAR slots.
        int slots = campStudentSlotChecker.getCampSlots(campName);
        if (slots == IntErrorCodes.CAMP_NOT_FOUND) {
            System.out.println("Failed to register. There is no such camp with this camp name!");
            return;
        }
        if (slots == IntErrorCodes.INSUFFICIENT_STUDENT_SLOTS) {
            System.out.println("Failed to register. There are no more student slots left!");
            return;
        }

        // Slots avail since it passed error checking, registration created and added to
        // database. Reduce avail camp attendee slots.
        registrationDataBase.getAllRegistrations().add(new Registration(student.getName(), campName, "Camp Attendee"));
        campStudentSlotReducer.reduceCampSlots(campName);
        System.out.printf("You have successfully registered for the camp as an attendee! Camp Name: %s\n", campName);
    }
}
