package registration;

import camp.*;
import misc.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that helps to register a student into a camp as a camp committee member.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CommitteeCampRegisterer implements IRegisterCommittee {
    /**
     * This CommitteeCampRegisterer's associated registration database.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * An interface used by CommitteeCampRegisterer to check if there are still available camp committee slots in the camp.
     */
    private IGetCampSlots campCommitteeSlotChecker;

    /**
     * An interface used by CommitteeCampRegisterer to check if the camp's faculty is open to the student.
     */
    private ICheckSchoolMatch checkSchoolMatch;

    /**
     * An interface used by CommitteeCampRegisterer to check if the registration date has closed.
     */
    private ICheckRegistrationClosed registrationClosedChecker;

    /**
     * An interface used by CommitteeCampRegisterer to check if the student has already registered as a camp committee member in other camps.
     */
    private IGetCampsRegistered registeredCampNamesGetter;

    /**
     * An interface used by CommitteeCampRegisterer to check if the student is already registered to camps that may clash with 
     * this new camp's dates.
     */
    private ICheckNoClash clashWithRegisteredChecker;

    /**
     * An interface used by CommitteeCampRegisterer to reduce the remaining number of camp committee slots upon successful registration
     * of the student as camp committee member.
     */
    private IReduceCampSlots campCommitteeSlotReducer;

    /**
     * An interface used by CommitteeCampRegisterer to check if the camp is even visible and open to students for registration.
     */
    private ICheckCampVisibility campvisibilityChecker;

    /**
     * Creates a new CommitteeCampRegisterer with its associated registration database and interfaces required to 
     * perform its method functions successfully. These interfaces are obtained from the CampDataBase and this constructor should
     * automatically be called upon the creation of a {@link RegistrationDataBase} or if not, after using the static method from {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This CommitteeCampRegisterer's associated registration database.
     * @param campCommitteeSlotChecker An interface used by CommitteeCampRegisterer to check if there are still available camp committee slots in the camp.
     * @param checkSchoolMatch An interface used by CommitteeCampRegisterer to check if the camp's faculty is open to the student.
     * @param registrationClosedChecker An interface used by CommitteeCampRegisterer to check if the registration date has closed.
     * @param registeredCampNamesGetter An interface used by CommitteeCampRegisterer to check if the student has already registered as a camp committee member in other camps.
     * @param clashWithRegisteredChecker An interface used by CommitteeCampRegisterer to check if the student is already registered to camps that may clash with 
     * this new camp's dates.
     * @param campCommitteeSlotReducer An interface used by CommitteeCampRegisterer to reduce the remaining number of camp committee slots upon successful registration
     * of the student as camp committee member.
     * @param campvisibilityChecker An interface used by CommitteeCampRegisterer to check if the camp is even visible and open to students for registration.
     */
    public CommitteeCampRegisterer(RegistrationDataBase registrationDataBase, IGetCampSlots campCommitteeSlotChecker,
            ICheckSchoolMatch checkSchoolMatch, ICheckRegistrationClosed registrationClosedChecker,
            IGetCampsRegistered registeredCampNamesGetter, ICheckNoClash clashWithRegisteredChecker,
            IReduceCampSlots campCommitteeSlotReducer, ICheckCampVisibility campvisibilityChecker) {
        this.registrationDataBase = registrationDataBase;
        this.campCommitteeSlotChecker = campCommitteeSlotChecker;
        this.checkSchoolMatch = checkSchoolMatch;
        this.registrationClosedChecker = registrationClosedChecker;
        this.registeredCampNamesGetter = registeredCampNamesGetter;
        this.clashWithRegisteredChecker = clashWithRegisteredChecker;
        this.campCommitteeSlotReducer = campCommitteeSlotReducer;
        this.campvisibilityChecker = campvisibilityChecker;
    }

    // We return a new CampCommittee object but with a student reference upon
    // success.
    // If fail, we simply return the original student reference. The result can be
    // assigned to the old student reference in main.

    public Student registerCamp(Student student, String campName) {
        /*
         * Error checks:
         * 1.Check if student is already a camp committee member
         * 2.Check if its visible.
         * 3.Check its open to his school
         * 4.Check if he alr registered to camp/dereged before
         * 5.Check if closed reg
         * 6.Check if clash
         * 7.Check if have campcom slot
         * 
         * Any of the above fails, return student himself.
         * Else Register Campcom by creating the registration entry and put into DB,
         * then create and return a CAMPCOM object with said string and
         * IsCampCommittee=true.
         */

        // If already a campcom,can't register to be another
        if (student.getIsCommittee() == true) {
            System.out.println("Registration failed! You cannot be a Camp Committee member for more than one camp!");
            return student;
        }

        boolean returnVal = campvisibilityChecker.isCampVisible(campName);
        if (!returnVal) {
            return student;
        }

        // Error checks if the camp is even open to the student, or exists.
        returnVal = checkSchoolMatch.checkSchoolMatch(student, campName);
        if (!returnVal)// means mismatch occured, or school doesn't exist. Error message printed by
                       // checkSchoolMatch.
        {
            return student;
        }

        // Check if student has already registered/deregistered from this camp before
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
                return student;
            }
        }

        // Checks if past register closing date.
        if (registrationClosedChecker.isRegistrationClosed(campName)) {
            System.out.println("Failed to register. Registration has already been closed!");
            return student;
        }

        // Checks if dates clash
        ArrayList<String> allRegisteredCamps = registeredCampNamesGetter.getRegisteredCampNames(student.getName());
        if (!clashWithRegisteredChecker.checkNoClash(allRegisteredCamps, campName)) {
            System.out.println("Failed to register. Dates clash with existing registered camp!");
            return student;
        }

        // Check if there are avail campComm slots
        int slots = campCommitteeSlotChecker.getCampSlots(campName);
        if (slots == IntErrorCodes.CAMP_NOT_FOUND) {
            System.out.println("Failed to register. There is no such camp with this camp name!");
            return student;
        }
        if (slots == IntErrorCodes.INSUFFICIENT_COMMITTEE_SLOTS) {
            System.out.println("Failed to register. There are no more Camp Committee slots left!");
            return student;
        }

        // Passed all error checking, create entry for campcom registration, and promote
        // student to campcom, return that campcom object.
        registrationDataBase.getAllRegistrations().add(new Registration(student.getName(), campName, "Camp Committee"));
        campCommitteeSlotReducer.reduceCampSlots(campName);
        System.out.printf("You have successfully registered for the camp as an committee member! Camp Name: %s\n",
                campName);
        return new CampCommittee(student, campName);

    }
}