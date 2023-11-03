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

        ArrayList<Camp> allCamps=campDataBase.getAllCamps();
        allCamps.add(newCamp);

    }
}