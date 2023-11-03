package camp;

import java.util.ArrayList;

public class CampDataBase 
{
    private ArrayList<Camp> allCamps;//2d array so we can separate by staff who creates it.

    //Association with the manager classes.
    private StaffCampCreator staffCampCreator;
    private StaffCampDeleter staffCampDeleter;
    private StaffCampEditor staffCampEditor;
    private StaffViewAllCamps staffViewAllCamps;
    private StaffViewOwnCamps staffViewOwnCamps;

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

        studentViewAllCamps=new StudentViewAllCamps(this);

    }

    public StaffCampCreator getStaffCampCreator(){return staffCampCreator;}
    public StaffCampDeleter getStaffCampDeleter(){return staffCampDeleter;}
    public StaffCampEditor getStaffCampEditor(){return staffCampEditor;}
    public StaffViewAllCamps getStaffViewAllCamps(){return staffViewAllCamps;}
    public StaffViewOwnCamps getStaffViewOwnCamps(){return staffViewOwnCamps;}

    public StudentViewAllCamps getStudentViewAllCamps(){return studentViewAllCamps;}

    public ArrayList<Camp> getAllCamps() {return allCamps;}



}
