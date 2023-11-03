package camp;

import java.util.ArrayList;

public class StaffViewAllCamps implements IViewAllCamps
{
    private CampDataBase campDataBase;
    public StaffViewAllCamps(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public void viewAllCamps(User user)
    {
        //Can potentially assert if user is staff here but shouldn't be needed!
        ArrayList<Camp> allCamps=campDataBase.getAllCamps();

        System.out.println("List of all camps:\n");

        for(int i=0;i<allCamps.size();++i)
        {
            Camp curCamp=allCamps.get(i);
            System.out.printf("Staff in charge: %s\nCamp name:%s\nRegistration Closing Date:%s\nTotal Slots:%d\n\n",curCamp.getStaffInCharge(),curCamp.getCampName(),curCamp.getStringRegClosingDate(),curCamp.getTotalSlots());
        }
    }
}
