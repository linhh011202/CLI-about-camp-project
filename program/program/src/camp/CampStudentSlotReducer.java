package merge;

import java.util.ArrayList;

public class CampStudentSlotReducer implements IReduceCampSlots
{
    private CampDataBase campDataBase;
    
    public CampStudentSlotReducer(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public void reduceCampSlots(String campName)
    {
        ArrayList<Camp> allCamps=campDataBase.getAllCamps();
        //Search camps for campName to reduce camp slot for that camp. Should be able to find, since called by Registerer who shd error check
        for(int i=0;i<allCamps.size();++i)
        {
            if(allCamps.get(i).getCampName().equals(campName))
            {
                Camp campToEdit=allCamps.get(i);
                //Reduce available attendee slots by 1.
                campToEdit.setAvailableAttendeeSlots(campToEdit.getAvailableAttendeeSlots()-1);
                return;
            }
        }
    }
}

