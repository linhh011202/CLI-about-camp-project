package camp;

import java.util.ArrayList;

public class StudentViewAllCamps implements IViewAllCamps
{
    private CampDataBase campDataBase;
    public StudentViewAllCamps(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public void viewAllCamps(User user,IFilterCamps iFilterCamps)
    {
        iFilterCamps.filterCamps();//Filter camps according to filter set by user.

        ArrayList<Camp> allCamps=campDataBase.getAllCamps();
        System.out.println("List of all camps visible to you:\n");
        
        for(int i=0;i<allCamps.size();++i)
        {
            Camp curCamp=allCamps.get(i);

            //Could use an instanceOf operator here to check the downcasting below but the code is so long alr TT
            //Only shows camps that are visible, AND within the student's faculty/NTU.
            if(curCamp.getVisibility())
            {   
                if(curCamp.getOpenTo()==Faculty.NTU || (curCamp.getOpenTo()==(((Student)user).getFaculty()))) 
                {
                   curCamp.printCamp();
                }
            }
        }
    }
}
