package camp;

import java.util.ArrayList;

public class StaffViewAllCamps implements IViewAllCamps
{
    private CampDataBase campDataBase;
    public StaffViewAllCamps(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public void viewAllCamps(User user,ISortCamps iSortCamps)
    {
        //Can potentially assert if user is staff here but shouldn't be needed!

        iSortCamps.sortCamps();//Filters camps according to filter set by user.

        ArrayList<Camp> allCamps=campDataBase.getAllCamps();

        System.out.println("List of all camps:\n");

        for(int i=0;i<allCamps.size();++i)
        {
            Camp curCamp=allCamps.get(i);
            curCamp.printCamp();
        }
    }
}
