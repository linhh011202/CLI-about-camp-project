package camp;

import java.util.ArrayList;

public class StaffViewOwnCamps implements IViewOwnCamps
{
    private CampDataBase campDataBase;
    public StaffViewOwnCamps(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public void viewOwnCamps(User user)
    {
        //Can potentially assert if user is staff here but shouldn't be needed!
        ArrayList<Camp> allCamps=campDataBase.getAllCamps();

        //If no camps
        if(allCamps.size()==0)
        {
                System.out.printf("There are no camps that you own to display!\n");
                return;
        }

        //print staff's camps
        System.out.printf("List of camps created by you:\n");

        boolean noCamps=true;
        for(int i=0;i<allCamps.size();++i)
        {
            //Check if row has any camps, or if the row belongs to said staff. If yes, print the whole row and return
            if(allCamps.get(i).getStaffInCharge().equals(user.getName()))
            {
                Camp curCamp=allCamps.get(i);
                System.out.printf("Staff in charge: %s\nCamp name:%s\nRegistration Closing Date:%s\nTotal Slots:%d\n\n",curCamp.getStaffInCharge(),curCamp.getCampName(),curCamp.getStringRegClosingDate(),curCamp.getTotalSlots());
                noCamps=false;
            }
        }
        if(noCamps)
        {
            System.out.printf("There are no camps that you own to display!\n");
        }

    }
}
