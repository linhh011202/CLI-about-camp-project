package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/** 
 * Represents a Registration Database. A Registraion database can store multiple Registration objects and provides many manager classes that implements
 * various interfaces for other uses to interact with the database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class RegistrationDataBase {
    /**
     * This RegistrationDataBase's array of all Registrations.
     */
    private ArrayList<Registration> allRegistrations;

    // Association with the manager classes.
    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to create a registration entry as an attendee within the database.
     */
    private StudentCampRegisterer studentCampRegisterer;

    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to change an entry to be deregistered in the database.
     */
    private StudentCampDeregisterer studentCampDeregisterer;

    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to get a list of camps that a student is registered for in the database.
     */
    private RegisteredCampNamesGetter registeredCampNamesGetter;

    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to create a registration entry as a camp committee member 
     * in the database.
     */
    private CommitteeCampRegisterer committeeCampRegisterer;

    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to get a list of camps and respectives roles that a student has registered
     * for in the database.
     */
    private RegisteredCampNamesRolesGetter registeredCampNamesRolesGetter;

    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to view the details of all the camps a student has registered for.
     */
    private StudentRegisteredCampsViewer studentRegisteredCampsViewer;

    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to check if a student is registered as an attendee
     * in a given camp within the registration database.
     */
    private AttendeeRegistrationChecker attendeeRegistrationChecker;

    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to if a student is registered as an camp committee
     * member in a given camp within the registration database.
     */
    private CommitteeRegistrationChecker committeeRegistrationChecker;

    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to obtain the list of students and their respective roles
     * in a given camp.
     */
    private RegisteredStudentNamesRolesGetter registeredStudentNamesRolesGetter;

    /**
     * This RegistrationDatabase's class that implements an interface to allow clients to obtain a list of camp names that a student 
     * has registered as a committee for.
     */
    private ListOfCampsIsCommiteeOfGetter listOfCampsIsCommiteeOfGetter;


    /**
     * Creates a new RegistrationDatabase class. It initialises all the associated classes that will be used by clients as interfaces.
     * It also tries to find a storage txt file to scan and initialise itself with any Registration entries that might have been stored from
     * previous runs.
     */
    public RegistrationDataBase() {
        allRegistrations = new ArrayList<Registration>(0);
        try{
            readFromStorage();
        }catch(Exception exception)
        {
            ;
        }
    }

    // CRDB InterfaceInitialiser will use this function to initialise registrationDB
    // with the CampDB interfaces that it needs.
    /** Some classes provided by this Registration uses interfaces from the Camp Database. This function takes in the 
     * classes from the camp database as interfaces and initialises this Registration Database's classes that need it.
     * This function should be called by {@link CRDBInterfaceInitialiser}, instead of manually using the getter methods
     * from the camp database class to call this method.
     * 
     * @param campStudentSlotChecker Interface used to check camp database if there are still attendee slots to register for.
     * @param campStudentSlotReducer Interface used to reduce number of attendee slots in camp database if registration is successful.
     * @param checkSchoolMatch Interface used to check camp database if the camp faculty matches with the student to allow registration.
     * @param campStudentSlotIncreaser Interface used to increment number of slots available in camp database if a student deregisters.
     * @param clashwithRegisteredChecker Interface used to check camp database if a student is trying to register for a camp that clashes 
     * with his existing schedule.
     * @param registrationClosedChecker Interface used to check camp database if the camp a student wants to register for already 
     * has its registration closed.
     * @param campCommitteeSlotChecker Interface used to check the camp database if there are still camp committee slots to register for.
     * @param campCommitteeSlotReducer Interface used to reduce number of camp committee slots in camp database if registration is successful.
     * @param registeredCampsPrinter Interface used to print the details of the camps that a student has registered for. This details are in the camp
     * database
     * @param campVisibilityChecker Interface used to check if a school is even visible to a student for registration.
     */
    public void InitialiseRegistrationDBManagers(IGetCampSlots campStudentSlotChecker,
            IReduceCampSlots campStudentSlotReducer, ICheckSchoolMatch checkSchoolMatch,
            IIncreaseCampSlots campStudentSlotIncreaser, ICheckNoClash clashwithRegisteredChecker,
            ICheckRegistrationClosed registrationClosedChecker, IGetCampSlots campCommitteeSlotChecker,
            IReduceCampSlots campCommitteeSlotReducer, IPrintRegisteredCamps registeredCampsPrinter,
            ICheckCampVisibility campVisibilityChecker) {
        registeredCampNamesGetter = new RegisteredCampNamesGetter(this);
        studentCampRegisterer = new StudentCampRegisterer(this, campStudentSlotChecker, campStudentSlotReducer,
                checkSchoolMatch, clashwithRegisteredChecker, registrationClosedChecker, registeredCampNamesGetter,
                campVisibilityChecker);
        studentCampDeregisterer = new StudentCampDeregisterer(this, campStudentSlotIncreaser);
        committeeCampRegisterer = new CommitteeCampRegisterer(this, campCommitteeSlotChecker, checkSchoolMatch,
                registrationClosedChecker, registeredCampNamesGetter, clashwithRegisteredChecker,
                campCommitteeSlotReducer, campVisibilityChecker);
        registeredCampNamesRolesGetter = new RegisteredCampNamesRolesGetter(this);
        studentRegisteredCampsViewer = new StudentRegisteredCampsViewer(this, registeredCampNamesRolesGetter,
                registeredCampsPrinter);
        attendeeRegistrationChecker = new AttendeeRegistrationChecker(this);
        committeeRegistrationChecker = new CommitteeRegistrationChecker(this);
        registeredStudentNamesRolesGetter = new RegisteredStudentNamesRolesGetter(this);
        listOfCampsIsCommiteeOfGetter = new ListOfCampsIsCommiteeOfGetter(this);

    }

    //Read and write to storage
     /**
     * Writes this Registration Database's array of Registration entries into a txt file. 
     * @throws IOException Throws an exception if it is unable to find the file to read or write to.
     */
    public void writeToStorage() throws IOException {
        File directory = new File("project\\src\\DataBaseInformation\\RegInfo");
    
        // Check if have directory, else create if needed
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        try (FileOutputStream fileOutputStream = new FileOutputStream("project\\src\\DataBaseInformation\\RegInfo\\RegInfo.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            for (int i = 0; i < allRegistrations.size(); ++i) {
                objectOutputStream.writeObject(allRegistrations.get(i));
            }
    
            objectOutputStream.flush();
        }
    }

    /**
     * Searches for the designated storage txt file to read in Registration data from previous app runs, and adds those camps to this 
     * Registration database. If there is no storage file, does not read in anything and no new Registration entries are added to this Registration Database.
     * @throws IOException Thrown if it is unable to find the file to read or write to.
     * @throws ClassNotFoundException Thrown if unable to find Camp class that we are trying to reference.
     */
    public void readFromStorage() throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream("project\\src\\DataBaseInformation\\RegInfo\\RegInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) 
        {
            while (fileInputStream.available() > 0) {
                Registration registration = (Registration) objectInputStream.readObject();
                allRegistrations.add(registration);
            }
        }
    }


    // Getters for the manager classes, to be used to initialise User classes in
    // Main.java so they can utilise said interface functions.

    /**
     * Gets this RegistrationDataBase's StudentCampRegisterer object.
     * @return This RegistrationDataBase's StudentCampRegisterer object.
     */
    public StudentCampRegisterer getStudentCampRegisterer() {
        return studentCampRegisterer;
    }

    /**
     * Gets this RegistrationDataBase's StudentCampDeregisterer object.
     * @return This RegistrationDataBase's StudentCampDeregisterer object.
     */
    public StudentCampDeregisterer getStudentCampDeregisterer() {
        return studentCampDeregisterer;
    }

    /**
     * Gets this RegistrationDataBase's RegisteredCampNamesGetter object.
     * @return This RegistrationDataBase's RegisteredCampNamesGetter object.
     */
    public RegisteredCampNamesGetter getRegisteredCampNamesGetter() {
        return registeredCampNamesGetter;
    }

    /**
     * Gets this RegistrationDataBase's CommitteeCampRegisterer object.
     * @return This RegistrationDataBase's CommitteeCampRegisterer object.
     */
    public CommitteeCampRegisterer getCommitteeCampRegisterer() {
        return committeeCampRegisterer;
    }

    /**
     * Gets this RegistrationDataBase's RegisteredCampNamesRolesGetter object.
     * @return This RegistrationDataBase's RegisteredCampNamesRolesGetter object.
     */
    public RegisteredCampNamesRolesGetter getRegisteredCampNamesRolesGetter() {
        return registeredCampNamesRolesGetter;
    }

    /**
     * Gets this RegistrationDataBase's StudentRegisteredCampsViewer object.
     * @return This RegistrationDataBase's StudentRegisteredCampsViewer object.
     */
    public StudentRegisteredCampsViewer getStudentRegisteredCampsViewer() {
        return studentRegisteredCampsViewer;
    }

    /**
     * Gets this RegistrationDataBase's AttendeeRegistrationChecker object.
     * @return This RegistrationDataBase's AttendeeRegistrationChecker object.
     */
    public AttendeeRegistrationChecker getAttendeeRegistrationChecker() {
        return attendeeRegistrationChecker;
    }

    /**
     * Gets this RegistrationDataBase's CommitteeRegistrationChecker object.
     * @return This RegistrationDataBase's CommitteeRegistrationChecker object.
     */
    public CommitteeRegistrationChecker getCommitteeRegistrationChecker() {
        return committeeRegistrationChecker;
    }

    /**
     * Gets this RegistrationDataBase's RegisteredStudentNamesRolesGetter object.
     * @return This RegistrationDataBase's RegisteredStudentNamesRolesGetter object.
     */
    public RegisteredStudentNamesRolesGetter getRegisteredStudentNamesRolesGetter() {
        return registeredStudentNamesRolesGetter;
    }

    /**
     * Gets this RegistrationDataBase's ListOfCampsIsCommiteeOfGetter object.
     * @return This RegistrationDataBase's ListOfCampsIsCommiteeOfGetter object.
     */
    public ListOfCampsIsCommiteeOfGetter getListOfCampsIsCommiteeOfGetter() {
        return listOfCampsIsCommiteeOfGetter;
    }

    // debugging func
    /**
     * Prints all the registration entries within the database.
     */
    public void printDataBase() {
        for (int i = 0; i < allRegistrations.size(); ++i) {
            allRegistrations.get(i).printRegistration();
        }
    }

    /**
     * Gets This RegistrationDataBase's list of all registrations.
     * @return This RegistrationDataBase's list of all registrations.
     */
    public ArrayList<Registration> getAllRegistrations() {
        return allRegistrations;
    }

}
