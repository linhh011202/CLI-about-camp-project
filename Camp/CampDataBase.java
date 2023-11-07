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
    private FilterManager filterManager;

    //Association with the manager classes related to student interfaces.
    private StudentViewAllCamps studentViewAllCamps;

    //Association with the manager classes related to registrationDB interfaces.
    private CampStudentSlotChecker campStudentSlotChecker;
    private CampStudentSlotReducer campStudentSlotReducer;

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

        filterManager=new FilterManager(this);

        studentViewAllCamps=new StudentViewAllCamps(this);

        campStudentSlotChecker=new CampStudentSlotChecker(this);
        campStudentSlotReducer=new CampStudentSlotReducer(this);

    }
    
    //Getters for the manager classes, to be used to initialise User classes in Main.java so they can utilise said interface functions.
    
    public StaffCampCreator getStaffCampCreator(){return staffCampCreator;}
    public StaffCampDeleter getStaffCampDeleter(){return staffCampDeleter;}
    public StaffCampEditor getStaffCampEditor(){return staffCampEditor;}
    public StaffViewAllCamps getStaffViewAllCamps(){return staffViewAllCamps;}
    public StaffViewOwnCamps getStaffViewOwnCamps(){return staffViewOwnCamps;}

    public FilterManager getFilterManager(){return filterManager;}

    public StudentViewAllCamps getStudentViewAllCamps(){return studentViewAllCamps;}

    public CampStudentSlotChecker getCampStudentSlotChecker(){return campStudentSlotChecker;}
    public CampStudentSlotReducer getCampStudentSlotReducer(){return campStudentSlotReducer;}

    public ArrayList<Camp> getAllCamps() {return allCamps;}



}
