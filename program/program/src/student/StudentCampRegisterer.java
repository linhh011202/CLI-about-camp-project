package student;

import java.util.ArrayList;

public class StudentCampRegisterer implements IRegisterCamp {
    private RegistrationDataBase registrationDataBase;
    private IGetCampSlots campStudentSlotChecker;
    private IReduceCampSlots campStudentSlotReducer;
    private ICheckSchoolMatch checkSchoolMatch;
    private IGetCampsRegistered registeredCampNamesGetter;
    private ICheckNoClash clashWithRegisteredChecker;
    private ICheckRegistrationClosed registrationClosedChecker;
    private ICheckCampVisibility campvisibilityChecker;

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
