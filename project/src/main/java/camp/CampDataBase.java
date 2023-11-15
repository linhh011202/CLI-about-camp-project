package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.io.*;
import java.util.ArrayList;

//Once constructed, will read from storage.
//Before app closes, remember to call writeToStorage to store the info of camps.

public class CampDataBase {
    private ArrayList<Camp> allCamps;

    // Association with the manager classes related to staff interfaces.
    private StaffCampCreator staffCampCreator;
    private StaffCampDeleter staffCampDeleter;
    private StaffCampEditor staffCampEditor;
    private StaffViewAllCamps staffViewAllCamps;
    private StaffViewOwnCamps staffViewOwnCamps;
    private StaffStudentReportGenerator staffStudentReportGenerator;
    private ListCampsStaffCreatedGetter listCampsStaffCreatedGetter;
    private StaffPerformanceReportGenerator staffPerformanceReportGenerator;

    // Association with the manager classes related to Sorting Interfaces.
    private SortManager sortManager;

    // Manager class related to filter interface
    private FilterManager filterManager;

    // Association with the manager classes related to student interfaces.
    private StudentViewAllCamps studentViewAllCamps;
    private CampComStudentReportGenerator campComStudentReportGenerator;

    // Association with the manager classes related to registrationDB interfaces.
    private CampStudentSlotChecker campStudentSlotChecker;
    private CampStudentSlotReducer campStudentSlotReducer;
    private CampStudentSlotIncreaser campStudentSlotIncreaser;

    private CheckSchoolMatch checkSchoolMatch;
    private ClashWithRegisteredChecker clashWithRegisteredChecker;
    private RegistrationClosedChecker registrationClosedChecker;
    private CampCommitteeSlotChecker campCommitteeSlotChecker;
    private CampCommitteeSlotReducer campCommitteeSlotReducer;
    private RegisteredCampsPrinter registeredCampsPrinter;
    private CampVisibilityChecker campVisibilityChecker;

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
            System.out.printf("No existing Camp information to retrieve from storage!\n");
        }
    }

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
    public void writeToStorage() throws IOException {
        File directory = new File("project\\src\\CampInfo");
    
        // Create the necessary directories if they don't exist
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        try (FileOutputStream fileOutputStream = new FileOutputStream("project\\src\\CampInfo\\CampInfo.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            for (int i = 0; i < allCamps.size(); ++i) {
                objectOutputStream.writeObject(allCamps.get(i));
            }
    
            objectOutputStream.flush();
        }
    }

    public void readFromStorage() throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream("project\\src\\CampInfo\\CampInfo.txt");
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

    public StaffCampCreator getStaffCampCreator() {
        return staffCampCreator;
    }

    public StaffCampDeleter getStaffCampDeleter() {
        return staffCampDeleter;
    }

    public StaffCampEditor getStaffCampEditor() {
        return staffCampEditor;
    }

    public StaffViewAllCamps getStaffViewAllCamps() {
        return staffViewAllCamps;
    }

    public StaffViewOwnCamps getStaffViewOwnCamps() {
        return staffViewOwnCamps;
    }

    public StaffStudentReportGenerator getStaffStudentReportGenerator() {
        return staffStudentReportGenerator;
    }

    public ListCampsStaffCreatedGetter getListCampsStaffCreatedGetter() {
        return listCampsStaffCreatedGetter;
    }

    public StaffPerformanceReportGenerator getStaffPerformanceReportGenerator() {
        return staffPerformanceReportGenerator;
    }

    public SortManager getSortManager() {
        return sortManager;
    }

    public FilterManager getFilterManager() {
        return filterManager;
    }

    public StudentViewAllCamps getStudentViewAllCamps() {
        return studentViewAllCamps;
    }

    public CampComStudentReportGenerator getCampComStudentReportGenerator() {
        return campComStudentReportGenerator;
    }

    public CampStudentSlotChecker getCampStudentSlotChecker() {
        return campStudentSlotChecker;
    }

    public CampStudentSlotReducer getCampStudentSlotReducer() {
        return campStudentSlotReducer;
    }

    public CampStudentSlotIncreaser getCampStudentSlotIncreaser() {
        return campStudentSlotIncreaser;
    }

    public CheckSchoolMatch getCheckSchoolMatch() {
        return checkSchoolMatch;
    }

    public ClashWithRegisteredChecker getClashWithRegisteredChecker() {
        return clashWithRegisteredChecker;
    }

    public RegistrationClosedChecker getRegistrationClosedChecker() {
        return registrationClosedChecker;
    }

    public CampCommitteeSlotChecker getCampCommitteeSlotChecker() {
        return campCommitteeSlotChecker;
    }

    public CampCommitteeSlotReducer getCampCommitteeSlotReducer() {
        return campCommitteeSlotReducer;
    }

    public RegisteredCampsPrinter getRegisteredCampsPrinter() {
        return registeredCampsPrinter;
    }

    public CampVisibilityChecker getCampVisibilityChecker() {
        return campVisibilityChecker;
    }

    public ArrayList<Camp> getAllCamps() {
        return allCamps;
    }

}
