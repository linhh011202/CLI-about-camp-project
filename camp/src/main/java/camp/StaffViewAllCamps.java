package camp;

import java.util.ArrayList;

public class StaffViewAllCamps implements IViewAllCamps
{
    private CampDataBase campDataBase;
    public StaffViewAllCamps(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public void viewAllCamps(User user,ISortCamps iSortCamps,IFilterCamps iFilterCamps,String filterString)
    {
        //Can potentially assert if user is staff here but shouldn't be needed!

        iSortCamps.sortCamps();//Sorts camps according to sorting set by user.
        iFilterCamps.filterCamps(filterString);//Sets the isFilteredOut flag in the camps in campDB.

        ArrayList<Camp> allCamps=campDataBase.getAllCamps();

        System.out.println("List of all camps:\n");
        boolean noCamps=true;
        for(int i=0;i<allCamps.size();++i)
        {
            Camp curCamp=allCamps.get(i);
            if(!curCamp.getIsFilteredOut())
            {
                curCamp.printCamp();
                noCamps=false;
            }
        }
        if(noCamps)
        {
            System.out.printf("There are no camps to display!\n");
        }
    }
}
