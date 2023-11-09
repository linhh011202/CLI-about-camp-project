package camp;

import java.util.ArrayList;

public class CampDataBase 
{
    private ArrayList<Camp> allCamps;

    //Association with the manager classes related to staff interfaces.
    private StaffCampCreator staffCampCreator;
    private StaffCampDeleter staffCampDeleter;
    private StaffCampEditor staffCampEditor;
    private StaffViewAllCamps staffViewAllCamps;
    private StaffViewOwnCamps staffViewOwnCamps;

    //Association with the manager classes related to filter interfaces.
    private SortManager sortManager;

    //Association with the manager classes related to student interfaces.
    private StudentViewAllCamps studentViewAllCamps;

    //Association with the manager classes related to registrationDB interfaces.
    private CampStudentSlotChecker campStudentSlotChecker;
    private CampStudentSlotReducer campStudentSlotReducer;
    private CampStudentSlotIncreaser campStudentSlotIncreaser;
    private CheckSchoolMatch checkSchoolMatch;
    private ClashWithRegisteredChecker clashWithRegisteredChecker;
    private RegistrationClosedChecker registrationClosedChecker;
    private CampCommitteeSlotChecker campCommitteeSlotChecker;
    private CampCommitteeSlotReducer campCommitteeSlotReducer;
    private RegisteredCampsPrinter registeredCampsPrinter;

    public CampDataBase()
    {
        //Probably read in the data from files, but for now we make it empty at the start every time.
        allCamps=new ArrayList<Camp>(1);
        //add lists to each row (diff staff=diff rows)

        //Initialise Associated classes. (maybe its a composition now then)
        staffCampCreator=new StaffCampCreator(this);
        staffCampDeleter=new StaffCampDeleter(this);
        staffCampEditor=new StaffCampEditor(this);
        staffViewAllCamps=new StaffViewAllCamps(this);
        staffViewOwnCamps=new StaffViewOwnCamps(this);

        sortManager=new SortManager(this);

        studentViewAllCamps=new StudentViewAllCamps(this);

        campStudentSlotChecker=new CampStudentSlotChecker(this);
        campStudentSlotReducer=new CampStudentSlotReducer(this);
        campStudentSlotIncreaser=new CampStudentSlotIncreaser(this);
        checkSchoolMatch= new CheckSchoolMatch(this);
        clashWithRegisteredChecker=new ClashWithRegisteredChecker(this);
        registrationClosedChecker=new RegistrationClosedChecker(this);
        campCommitteeSlotChecker=new CampCommitteeSlotChecker(this);
        campCommitteeSlotReducer=new CampCommitteeSlotReducer(this);
        registeredCampsPrinter=new RegisteredCampsPrinter(this);
    }

    
    //Getters for the manager classes, to be used to initialise User classes in Main.java so they can utilise said interface functions.
    
    public StaffCampCreator getStaffCampCreator(){return staffCampCreator;}
    public StaffCampDeleter getStaffCampDeleter(){return staffCampDeleter;}
    public StaffCampEditor getStaffCampEditor(){return staffCampEditor;}
    public StaffViewAllCamps getStaffViewAllCamps(){return staffViewAllCamps;}
    public StaffViewOwnCamps getStaffViewOwnCamps(){return staffViewOwnCamps;}

    public SortManager getSortManager(){return sortManager;}

    public StudentViewAllCamps getStudentViewAllCamps(){return studentViewAllCamps;}

    public CampStudentSlotChecker getCampStudentSlotChecker(){return campStudentSlotChecker;}
    public CampStudentSlotReducer getCampStudentSlotReducer(){return campStudentSlotReducer;}
    public CampStudentSlotIncreaser getCampStudentSlotIncreaser(){return campStudentSlotIncreaser;}
    public CheckSchoolMatch getCheckSchoolMatch(){return checkSchoolMatch;}
    public ClashWithRegisteredChecker getClashWithRegisteredChecker(){return clashWithRegisteredChecker;}
    public RegistrationClosedChecker getRegistrationClosedChecker(){return registrationClosedChecker;}
    public CampCommitteeSlotChecker getCampCommitteeSlotChecker(){return campCommitteeSlotChecker;}
    public CampCommitteeSlotReducer getCampCommitteeSlotReducer(){return campCommitteeSlotReducer;}
    public RegisteredCampsPrinter getRegisteredCampsPrinter(){return registeredCampsPrinter;}

    public ArrayList<Camp> getAllCamps() {return allCamps;}



}
