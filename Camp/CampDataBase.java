package camp;

import java.util.ArrayList;

public class CampDataBase 
{
    private ArrayList<Camp> allCamps;

    //Association with the manager classes.
    private StaffCampCreator staffCampCreator;
    private StaffCampDeleter staffCampDeleter;
    private StaffCampEditor staffCampEditor;
    private StaffViewAllCamps staffViewAllCamps;
    private StaffViewOwnCamps staffViewOwnCamps;

    private FilterManager filterManager;

    private StudentViewAllCamps studentViewAllCamps;

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

    }
    
    //Getters for the manager classes, to be used to initialise User classes in Main.java so they can utilise said interface functions.
    
    public StaffCampCreator getStaffCampCreator(){return staffCampCreator;}
    public StaffCampDeleter getStaffCampDeleter(){return staffCampDeleter;}
    public StaffCampEditor getStaffCampEditor(){return staffCampEditor;}
    public StaffViewAllCamps getStaffViewAllCamps(){return staffViewAllCamps;}
    public StaffViewOwnCamps getStaffViewOwnCamps(){return staffViewOwnCamps;}

    public FilterManager getFilterManager(){return filterManager;}

    public StudentViewAllCamps getStudentViewAllCamps(){return studentViewAllCamps;}

    public ArrayList<Camp> getAllCamps() {return allCamps;}



}
