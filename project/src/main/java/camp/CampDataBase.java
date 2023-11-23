package camp;

import registration.*;

import java.io.*;
import java.util.ArrayList;

/** 
 * Represents a Camp Database. A camp database can store multiple camp objects and provides many manager classes that implements
 * various interfaces for other uses to interact with the database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CampDataBase {
    //Once constructed, will read from storage.
    //Before app closes, remember to call writeToStorage to store the info of camps.

    /**
     * This CampDataBase's array of all camps.
     */
    private ArrayList<Camp> allCamps;

    // Association with the manager classes related to staff interfaces.

    /**
     * This CampDataBase's class that implements an interface to allow clients to create camps within the database.
     */
    private StaffCampCreator staffCampCreator;

    /**
     * This CampDataBase's class that implements an interface to allow clients to delete camps within the database.
     */
    private StaffCampDeleter staffCampDeleter;

    /**
     * This CampDataBase's class that implements an interface to allow clients to edit camps within the database.
     */
    private StaffCampEditor staffCampEditor;

    /**
     * This CampDataBase's class that implements an interface to allow staffs to view all camps that they are allowed to view within
     * the database.
     */
    private StaffViewAllCamps staffViewAllCamps;

    /**
     * This CampDataBase's class that implements an interface to allow staffs to view all camps that they are in charge of
     * within the database.
     */
    private StaffViewOwnCamps staffViewOwnCamps;

    /**
     * This CampDataBase's class that implements an interface to allow staffs to generate camp reports for all camps that
     * they are in charge of within the database.
     */
    private StaffStudentReportGenerator staffStudentReportGenerator;

    /**
     * This CampDataBase's class that implements an interface to allow staffs to obtain a list of camp names in Strings for
     * the camps that they are in charge of within the database.
     */
    private ListCampsStaffCreatedGetter listCampsStaffCreatedGetter;

    /**
     * This CampDataBase's class that implements an interface to allow staffs to generate performance reports for camp committee
     * members for all the camps that they are in charge of within the database.
     */
    private StaffPerformanceReportGenerator staffPerformanceReportGenerator;

    // Association with the manager classes related to Sorting Interfaces.
    /**
     * This CampDataBase's class that implements an interface to allow clients to sort all the camps within the database.
     */
    private SortManager sortManager;

    // Manager class related to filter interface
    /**
     * This CampDataBase's class that implements an interface to allow clients to filter all the camps within the database.
     */
    private FilterManager filterManager;

    // Association with the manager classes related to student interfaces.
    /**
     * This CampDataBase's class that implements an interface to allow students to view all camps that are visible to them within
     * the database.
     */
    private StudentViewAllCamps studentViewAllCamps;

    /**
     * This CampDataBase's class that implements an interface to allow students to generate a camp report for camps that they are
     * committee members of, containing camp details and list of students and their respective roles.
     */
    private CampComStudentReportGenerator campComStudentReportGenerator;

    // Association with the manager classes related to registrationDB interfaces.
    /**
     * This CampDataBase's class that implements an interface to allow clients to check the number of available attendee slots
     * for a camp within the database.
     */
    private CampStudentSlotChecker campStudentSlotChecker;

    /**
     * This CampDataBase's class that implements an interface to allow clients to reduce the number of available attendee slots
     * for a camp within the database.
     */
    private CampStudentSlotReducer campStudentSlotReducer;

    /**
     * This CampDataBase's class that implements an interface to allow clients to increase the number of available attendee slots
     * for a camp within the database.
     */
    private CampStudentSlotIncreaser campStudentSlotIncreaser;

    /**
     * This CampDataBase's class that implements an interface to allow students to check if the camp is open to students of
     * their faculty.
     */
    private CheckSchoolMatch checkSchoolMatch;

    /**
     * This CampDataBase's class that implements an interface to allow clients to check if within the database, a given camp's date
     * clashes with a list of other camps.
     */
    private ClashWithRegisteredChecker clashWithRegisteredChecker;

    /**
     * This CampDataBase's class that implements an interface to allow clients to check within the database if a camp's registration
     * has closed.
     */
    private RegistrationClosedChecker registrationClosedChecker;

    /**
     * This CampDataBase's class that implements an interface to allow clients to check for the remaining available camp committee slots
     * for a camp within the database.
     */
    private CampCommitteeSlotChecker campCommitteeSlotChecker;

    /**
     * This CampDataBase's class that implements an interface to allow clients to reduce the number of camp committee slots for a 
     * camp within the database.
     */
    private CampCommitteeSlotReducer campCommitteeSlotReducer;

    /**
     * This CampDataBase's class that implements an interface to allow clients to print the list of camps that he is registered to.
     */
    private RegisteredCampsPrinter registeredCampsPrinter;

    /**
     * This CampDataBase's class that implements an interface to allow clients to check a camp's visibility status within the camp
     * database.
     */
    private CampVisibilityChecker campVisibilityChecker;


    /**
     * Creates a new CampDataBase class. It initialises all the associated classes that will be used by clients as interfaces.
     * It also tries to find a storage txt file to scan and initialise itself with any Camps that might have been stored from
     * previous runs.
     */
    public CampDataBase() {
        //Make it empty, then we read in automatically using readFromStorage at the end of constructor.
        allCamps = new ArrayList<Camp>(0);
        
        // Initialise Associated classes. (maybe its a composition now then)
        staffCampCreator = new StaffCampCreator(this);
        staffCampDeleter = new StaffCampDeleter(this);
        staffCampEditor = new StaffCampEditor(this);
        staffViewAllCamps = new StaffViewAllCamps(this);
        staffViewOwnCamps = new StaffViewOwnCamps(this);
        listCampsStaffCreatedGetter = new ListCampsStaffCreatedGetter(this);

        sortManager = new SortManager(this);

        studentViewAllCamps = new StudentViewAllCamps(this);

        campStudentSlotChecker = new CampStudentSlotChecker(this);
        campStudentSlotReducer = new CampStudentSlotReducer(this);
        campStudentSlotIncreaser = new CampStudentSlotIncreaser(this);
        checkSchoolMatch = new CheckSchoolMatch(this);
        clashWithRegisteredChecker = new ClashWithRegisteredChecker(this);
        registrationClosedChecker = new RegistrationClosedChecker(this);
        campCommitteeSlotChecker = new CampCommitteeSlotChecker(this);
        campCommitteeSlotReducer = new CampCommitteeSlotReducer(this);
        registeredCampsPrinter = new RegisteredCampsPrinter(this);
        campVisibilityChecker = new CampVisibilityChecker(this);

        try{
            readFromStorage();
        }catch(Exception exception)
        {
            ;
        }
    }

    /**
     * Some classes provided by this CampDataBase uses interfaces from the Registration Database. This function takes in the 
     * classes from the registration database as interfaces and initialises this CampDatabase's classes that need it.
     * @param attendeeRegistrationChecker Interface used by this CampDataBase's filter manager that checks 
     * if a student is an attendee of a camp, in order to filter by student attendee name.
     * @param committeeRegistrationChecker Interface used by this CampDataBase's filter manager that checks 
     * if a student is an committee member of a camp, in order to filter by camp committee name.
     * @param registeredStudentNamesRolesGetter Interface used by this CampDataBase's StaffStudentReportGenerator, StaffPerformanceReportGenerator and 
     * CampComStudentReportGenerator that obtains the list of students and their roles for a camp.
     * @param listOfCampsIsCommiteeOfGetter Interface used by this CampDataBase's CampComReportGenerator that obtains list of camps that a student
     * is camp committee of.
     */
    public void InitialiseCampDB(ICheckRegistration attendeeRegistrationChecker,
            ICheckRegistration committeeRegistrationChecker,
            IGetStudentNamesRolesRegistered registeredStudentNamesRolesGetter,
            IGetCampsIsCommittee listOfCampsIsCommiteeOfGetter) {
        filterManager = new FilterManager(this, attendeeRegistrationChecker, committeeRegistrationChecker);
        staffStudentReportGenerator = new StaffStudentReportGenerator(this, registeredStudentNamesRolesGetter);
        campComStudentReportGenerator = new CampComStudentReportGenerator(this, registeredStudentNamesRolesGetter,
                listOfCampsIsCommiteeOfGetter);
        staffPerformanceReportGenerator = new StaffPerformanceReportGenerator(this, registeredStudentNamesRolesGetter);
    }

    //Provides functions to read in from storage, and write to storage.
    /**
     * Writes this CampDataBase's array of Camps into a txt file. 
     * @throws IOException Throws an exception if it is unable to find the file to read or write to.
     */
    public void writeToStorage() throws IOException {
        File directory = new File("project\\src\\DataBaseInformation\\CampInfo");
    
        // Check if have directory, else create if needed
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        try (FileOutputStream fileOutputStream = new FileOutputStream("project\\src\\DataBaseInformation\\CampInfo\\CampInfo.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            for (int i = 0; i < allCamps.size(); ++i) {
                objectOutputStream.writeObject(allCamps.get(i));
            }
    
            objectOutputStream.flush();
        }
    }

    /**
     * Searches for the designated storage txt file to read in Camp data from previous app runs, and adds those camps to this 
     * CampDatabase. If there is no storage file, does not read in anything and no new Camps are added to this CampDataBase.
     * @throws IOException Thrown if it is unable to find the file to read or write to.
     * @throws ClassNotFoundException Thrown if unable to find Camp class that we are trying to reference.
     */
    public void readFromStorage() throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream("project\\src\\DataBaseInformation\\CampInfo\\CampInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) 
        {
            while (fileInputStream.available() > 0) {
                Camp camp = (Camp) objectInputStream.readObject();
                allCamps.add(camp);
            }
        }
    }



    // Getters for the manager classes, to be used to initialise User classes in
    // Main.java so they can utilise said interface functions.

    /**
     * Gets this CampDataBase's StaffCampCreator object.
     * @return This CampDataBase's StaffCampCreator object.
     */
    public StaffCampCreator getStaffCampCreator() {
        return staffCampCreator;
    }

    /**
     * Gets this CampDataBase's StaffCampDeleter object.
     * @return This CampDataBase's StaffCampDeleter object.
     */
    public StaffCampDeleter getStaffCampDeleter() {
        return staffCampDeleter;
    }

    /**
     * Gets this CampDataBase's StaffCampEditor object.
     * @return This CampDataBase's StaffCampEditor object.
     */
    public StaffCampEditor getStaffCampEditor() {
        return staffCampEditor;
    }

    /**
     * Gets this CampDataBase's StaffViewAllCamps object.
     * @return This CampDataBase's StaffViewAllCamps object.
     */
    public StaffViewAllCamps getStaffViewAllCamps() {
        return staffViewAllCamps;
    }

    /**
     * Gets this CampDataBase's StaffViewOwnCamps object.
     * @return This CampDataBase's StaffViewOwnCamps object.
     */
    public StaffViewOwnCamps getStaffViewOwnCamps() {
        return staffViewOwnCamps;
    }

    /**
     * Gets this CampDataBase's StaffStudentReportGenerator object.
     * @return This CampDataBase's StaffStudentReportGenerator object.
     */
    public StaffStudentReportGenerator getStaffStudentReportGenerator() {
        return staffStudentReportGenerator;
    }

    /**
     * Gets this CampDataBase's ListCampsStaffCreatedGetter object.
     * @return This CampDataBase's ListCampsStaffCreatedGetter object.
     */
    public ListCampsStaffCreatedGetter getListCampsStaffCreatedGetter() {
        return listCampsStaffCreatedGetter;
    }

    /**
     * Gets this CampDataBase's StaffPerformanceReportGenerator object.
     * @return This CampDataBase's StaffPerformanceReportGenerator object.
     */
    public StaffPerformanceReportGenerator getStaffPerformanceReportGenerator() {
        return staffPerformanceReportGenerator;
    }

    /**
     * Gets this CampDataBase's SortManager object.
     * @return This CampDataBase's SortManager object.
     */
    public SortManager getSortManager() {
        return sortManager;
    }

    /**
     * Gets this CampDataBase's FilterManager object.
     * @return This CampDataBase's FilterManager object.
     */
    public FilterManager getFilterManager() {
        return filterManager;
    }

    /**
     * Gets this CampDataBase's StudentViewAllCamps object.
     * @return This CampDataBase's StudentViewAllCamps object.
     */
    public StudentViewAllCamps getStudentViewAllCamps() {
        return studentViewAllCamps;
    }

    /**
     * Gets this CampDataBase's CampComStudentReportGenerator object.
     * @return This CampDataBase's CampComStudentReportGenerator object.
     */
    public CampComStudentReportGenerator getCampComStudentReportGenerator() {
        return campComStudentReportGenerator;
    }

    /**
     * Gets this CampDataBase's CampStudentSlotChecker object.
     * @return This CampDataBase's CampStudentSlotChecker object.
     */
    public CampStudentSlotChecker getCampStudentSlotChecker() {
        return campStudentSlotChecker;
    }

    /**
     * Gets this CampDataBase's CampStudentSlotReducer object.
     * @return This CampDataBase's CampStudentSlotReducer object.
     */
    public CampStudentSlotReducer getCampStudentSlotReducer() {
        return campStudentSlotReducer;
    }

    /**
     * Gets this CampDataBase's CampStudentSlotIncreaser object.
     * @return This CampDataBase's CampStudentSlotIncreaser object.
     */
    public CampStudentSlotIncreaser getCampStudentSlotIncreaser() {
        return campStudentSlotIncreaser;
    }

    /**
     * Gets this CampDataBase's CheckSchoolMatch object.
     * @return This CampDataBase's CheckSchoolMatch object.
     */
    public CheckSchoolMatch getCheckSchoolMatch() {
        return checkSchoolMatch;
    }

    /**
     * Gets this CampDataBase's ClashWithRegisteredChecker object.
     * @return This CampDataBase's ClashWithRegisteredChecker object.
     */
    public ClashWithRegisteredChecker getClashWithRegisteredChecker() {
        return clashWithRegisteredChecker;
    }

    /**
     * Gets this CampDataBase's RegistrationClosedChecker object.
     * @return This CampDataBase's RegistrationClosedChecker object.
     */
    public RegistrationClosedChecker getRegistrationClosedChecker() {
        return registrationClosedChecker;
    }

    /**
     * Gets this CampDataBase's CampCommitteeSlotChecker object.
     * @return This CampDataBase's CampCommitteeSlotChecker object.
     */
    public CampCommitteeSlotChecker getCampCommitteeSlotChecker() {
        return campCommitteeSlotChecker;
    }

    /**
     * Gets this CampDataBase's CampCommitteeSlotReducer object.
     * @return This CampDataBase's CampCommitteeSlotReducer object.
     */
    public CampCommitteeSlotReducer getCampCommitteeSlotReducer() {
        return campCommitteeSlotReducer;
    }

    /**
     * Gets this CampDataBase's RegisteredCampsPrinter object.
     * @return This CampDataBase's RegisteredCampsPrinter object.
     */
    public RegisteredCampsPrinter getRegisteredCampsPrinter() {
        return registeredCampsPrinter;
    }

    /**
     * Gets this CampDataBase's CampVisibilityChecker object.
     * @return This CampDataBase's CampVisibilityChecker object.
     */
    public CampVisibilityChecker getCampVisibilityChecker() {
        return campVisibilityChecker;
    }

    /**
     * Gets this CampDataBase's list of all camps.
     * @return This CampDataBase's list of all camps.
     */
    public ArrayList<Camp> getAllCamps() {
        return allCamps;
    }

}
