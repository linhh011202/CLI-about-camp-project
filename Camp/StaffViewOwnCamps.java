package camp;

import java.util.ArrayList;

public class StaffViewOwnCamps implements IViewOwnCamps
{
    private CampDataBase campDataBase;
    public StaffViewOwnCamps(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public void viewOwnCamps(User user)
    {
        //Can potentially assert if user is staff here but shouldn't be needed!
        ArrayList<ArrayList<Camp>> allCamps=campDataBase.getAllCamps();

        //If no camps
        if(allCamps.size()==0)
        {
                System.out.printf("There are no camps that you own to display!\n");
                return;
        }

        //print staff's camps
        for(int i=0;i<allCamps.size();++i)
        {
            //Check if row has any camps, or if the row belongs to said staff. If yes, print the whole row and return
            if(allCamps.get(i).size()==0)continue;
            
            else if(allCamps.get(i).get(0).getStaffInCharge()!=user.getName())
            {
                continue;
            }
            System.out.println("List of all your camps:\n");
            for(int j=0;j<allCamps.get(i).size();++j)
            {
                Camp curCamp=allCamps.get(i).get(j);
                System.out.printf("Staff in charge: %s\nCamp name:%s\nRegistration Closing Date:%s\nTotal Slots:%d\n\n",curCamp.getStaffInCharge(),curCamp.getCampName(),curCamp.getStringRegClosingDate(),curCamp.getTotalSlots());
            }
            return;
        }
        System.out.printf("There are no camps that you own to display!\n");
    }
}
