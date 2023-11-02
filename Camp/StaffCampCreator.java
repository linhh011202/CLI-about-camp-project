package camp;

import java.util.ArrayList;

public class StaffCampCreator implements ICreateCamp
{
    private CampDataBase campDataBase;
    
    public StaffCampCreator(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public void createCamp(String campName,String startDate,String endDate, String regClosingDate,boolean visibility, String location, int totalSlots,int campComSlots,String description,User user,Faculty openTo)
    {
        //Possible error checking if its not a staff?? But dont think we need it since there shouldn't be a place in the mainApp
        //where non-staffs can even call this func

        Camp newCamp = new Camp(campName,startDate,endDate, regClosingDate, visibility, location, totalSlots,campComSlots, description, user,openTo);
        
        //Checks first camp in each row. If same staffInCharge, add to row. Else keep finding. If can't find, we add a new row and insert it.
        ArrayList<ArrayList<Camp>> allCamps=campDataBase.getAllCamps();

        boolean staffRowExists=false;
        for(int i=0;i<allCamps.size();++i)
        {
            if(allCamps.get(i).size()==0)//If a row is empty, just insert
            {
                allCamps.get(i).add(newCamp);
                staffRowExists=true;
                break;
            }
            else if(allCamps.get(i).get(0).getStaffInCharge().equals(user.getName()))
            {
                allCamps.get(i).add(newCamp);
                staffRowExists=true;
                break;
            }
        }
        if(!staffRowExists)//Create new row and add this camp into it.
        {
            allCamps.add(new ArrayList<Camp>());
            allCamps.get(allCamps.size()-1).add(newCamp);
        }

    }
}