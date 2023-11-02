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
        
        //Find the staff's row of camps. If cant find, he has no camps to delete. 
        ArrayList<ArrayList<Camp>> allCamps=campDataBase.getAllCamps();

        for(int i=0;i<allCamps.size();++i)
        {
            if(allCamps.get(i).size()==0)//If a row is empty, check next rows
            {
                continue;
            }
            //If found his row, try find the ID and delete it.
            else if(allCamps.get(i).get(0).getStaffInCharge().equals(user.getName()))
            {
                for(int j=0;j<allCamps.get(i).size();++j)
                {
                    if(allCamps.get(i).get(j).getCampName().equals(campName))
                    {
                        allCamps.get(i).remove(j);
                        break;
                    }
                }
                break;
            }
        }
        //If can't find his row OR his row doesn't have campId, return false. (indicates failure to delete camp); Probably handled by mainAPP
        return false;

    }
}