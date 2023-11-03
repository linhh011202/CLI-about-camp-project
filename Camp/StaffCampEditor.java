package camp;

import java.util.ArrayList;

public class StaffCampEditor implements IEditCamp
{
    private CampDataBase campDataBase;
    public StaffCampEditor(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    //Looks for the specific camp object to return.
    private Camp findCamp(String staffName,String campName)
    {
        ArrayList<Camp> allCamps=campDataBase.getAllCamps();

        for(int i=0;i<allCamps.size();++i)
        {
           if(allCamps.get(i).getCampName().equals(campName)&& allCamps.get(i).getStaffInCharge().equals(staffName))
           {
                return allCamps.get(i);
           }
        }
        return null;
    }

    public boolean changeCampName(User user,String campName,String newCampName)
    {
        Camp campToEdit=findCamp(user.getName(),campName);
        if(campToEdit==null){return false;}//Unable to find camp under that editor to change.

        campToEdit.setCampName(newCampName);
        return true;
    }

    public boolean changeStartDate(User user,String campName,String newStartDate)
    {
        Camp campToEdit=findCamp(user.getName(),campName);
        if(campToEdit==null){return false;}//Unable to find camp under that editor to change.

        campToEdit.setStartDate(newStartDate);
        return true;
    }

    public boolean changeEndDate(User user,String campName,String newEndDate)
    {
        Camp campToEdit=findCamp(user.getName(),campName);
        if(campToEdit==null){return false;}//Unable to find camp under that editor to change.

        campToEdit.setEndDate(newEndDate);
        return true;
    }

    public boolean changeRegClosingDate(User user,String campName,String newRegClosingDate)
    {
        Camp campToEdit=findCamp(user.getName(),campName);
        if(campToEdit==null){return false;}//Unable to find camp under that editor to change.

        campToEdit.setregClosingDate(newRegClosingDate);
        return true;
    }

    public boolean changeVisibility(User user,String campName,boolean newVisibility)
    {
        Camp campToEdit=findCamp(user.getName(),campName);
        if(campToEdit==null){return false;}//Unable to find camp under that editor to change.

        campToEdit.setVisibility(newVisibility);
        return true;
    }

    public boolean changeLocation(User user,String campName,String newLocation)
    {
        Camp campToEdit=findCamp(user.getName(),campName);
        if(campToEdit==null){return false;}//Unable to find camp under that editor to change.

        campToEdit.setLocation(newLocation);
        return true;
    }

    public boolean changeTotalSlots(User user,String campName,int newTotalSlots)
    {
        Camp campToEdit=findCamp(user.getName(),campName);
        if(campToEdit==null){return false;}//Unable to find camp under that editor to change.

        campToEdit.setTotalSlots(newTotalSlots);
        return true;
    }

    public boolean changeCampComSlots(User user,String campName,int newCampComSlots)
    {
        Camp campToEdit=findCamp(user.getName(),campName);
        if(campToEdit==null){return false;}//Unable to find camp under that editor to change.

        campToEdit.setCampComSlots(newCampComSlots);
        return true;
    }

    public boolean changeDescription(User user,String campName,String newDescription)
    {
        Camp campToEdit=findCamp(user.getName(),campName);
        if(campToEdit==null){return false;}//Unable to find camp under that editor to change.

        campToEdit.setDescription(newDescription);
        return true;
    }

}
