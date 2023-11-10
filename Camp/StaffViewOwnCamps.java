package camp;

import java.util.ArrayList;

public class StaffViewOwnCamps implements IViewOwnCamps
{
    private CampDataBase campDataBase;
    public StaffViewOwnCamps(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public void viewOwnCamps(User user,ISortCamps iSortCamps,IFilterCamps iFilterCamps,String filterString)
    {
        //Can potentially assert if user is staff here but shouldn't be needed!

        iSortCamps.sortCamps();//Sorts camps according to sorting set by user.
        iFilterCamps.filterCamps(filterString);//Filter camps according to filter set by user.

        ArrayList<Camp> allCamps=campDataBase.getAllCamps();

        //print staff's camps
        System.out.printf("List of camps created by you:\n");
        
        //If no camps
        if(allCamps.size()==0)
        {
                System.out.printf("There are no camps to display!\n");
                return;
        }

        boolean noCamps=true;
        for(int i=0;i<allCamps.size();++i)
        {
            //Print if camp is owned by staff, and is NOT filtered out.
            if(allCamps.get(i).getStaffInCharge().equals(user.getName()) && !allCamps.get(i).getIsFilteredOut())
            {
                Camp curCamp=allCamps.get(i);
                curCamp.printCamp();
                noCamps=false;
            }
        }
        if(noCamps)
        {
            System.out.printf("There are no camps that you own to display!\n");
        }

    }
}
