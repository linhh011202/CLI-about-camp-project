package camp;

import java.util.ArrayList;

public class RegistrationDataBase 
{
    private ArrayList<Registration> allRegistrations;

    //Association with the manager classes.
    private StudentCampRegisterer studentCampRegisterer;

    public RegistrationDataBase(IGetCampSlots CampStudentSlotChecker,IReduceCampSlots CampStudentSlotReducer)
    {
        //Probably read in the data from files, but for now we make it empty at the start every time.
        allRegistrations=new ArrayList<Registration>(1);

        //Initialise Associated classes. 
        studentCampRegisterer=new StudentCampRegisterer(this,CampStudentSlotChecker,CampStudentSlotReducer);

    }
    
    //Getters for the manager classes, to be used to initialise User classes in Main.java so they can utilise said interface functions.
    
    public StudentCampRegisterer getStudentRegisterCamp(){return studentCampRegisterer;}

    //debugging func
    public void printDataBase()
    {
        for(int i=0;i<allRegistrations.size();++i)
        {
            allRegistrations.get(i).printRegistration();
        }
    }

    public ArrayList<Registration> getAllRegistrations()
    {
        return allRegistrations;
    }



}

