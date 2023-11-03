package camp;

import java.util.ArrayList;

public class StaffCampDeleter implements IDeleteCamp
{
    private CampDataBase campDataBase;
    
    public StaffCampDeleter(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public boolean deleteCamp(User user,String campName)
    {
        //Possible error checking if its not a staff?? But dont think we need it since there shouldn't be a place in the mainApp
        //where non-staffs can even call this func
        
        //Find the campName that has the StaffName as in-charge for row of camps.
        //If cant find because of no such camp, or camp is under diff staff, return false to indicate failure.
        ArrayList<Camp> allCamps=campDataBase.getAllCamps();

        for(int i=0;i<allCamps.size();++i)
        {
            if(allCamps.get(i).getCampName().equals(campName) && allCamps.get(i).getStaffInCharge().equals(user.getName()))
            {
                allCamps.remove(i);
                return true;
            }
        }
        //If can't find his row OR his row doesn't have campId, return false. (indicates failure to delete camp); Probably handled by mainAPP
        return false;

    }
}