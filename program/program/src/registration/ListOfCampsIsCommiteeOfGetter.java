package merge;

import java.util.ArrayList;

public class ListOfCampsIsCommiteeOfGetter implements IGetCampsIsCommittee
{
    private RegistrationDataBase registrationDataBase;

    public ListOfCampsIsCommiteeOfGetter(RegistrationDataBase registrationDataBase)
    {
        this.registrationDataBase=registrationDataBase;
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
