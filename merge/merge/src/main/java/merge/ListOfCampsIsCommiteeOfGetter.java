package merge;

import java.util.ArrayList;

public class ListOfCampsIsCommiteeOfGetter implements IGetCampsIsCommittee
{
    private CampDataBase campDataBase;

    public ListOfCampsIsCommiteeOfGetter(CampDataBase campDataBase)
    {
        this.campDataBase=campDataBase;
    }

    public ArrayList<String> getCampsIsCommittee(Student student)
    {
        ArrayList<String> campListIsCommittee= new ArrayList<String>(0);

        ArrayList<Registration> allRegistrations=registrationDataBase.getAllRegistrations();
        for(int i=0;i<allRegistrations.size();++i)
        {
            if(allRegistrations.get(i).getStudentName().equals(student.getName()) 
            && allRegistrations.get(i).getRole().equals("Camp Committee")
            && !allRegistrations.get(i).getDeregistered() ) 
            {
                campListIsCommittee.add(allRegistrations.get(i).getCampName());
            }
        }

        return campListIsCommittee;
    }
}
