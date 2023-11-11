package merge;

import java.util.ArrayList;

public class CommitteeRegistrationChecker implements ICheckRegistration
{
    private RegistrationDataBase registrationDataBase;

    public CommitteeRegistrationChecker(RegistrationDataBase registrationDataBase)
    {
        this.registrationDataBase=registrationDataBase;
    }

    public boolean checkRegistration(String studentName, String campName)
    {
        ArrayList<Registration> allRegistrations=registrationDataBase.getAllRegistrations();
        //Check all registrations for corresponding student name and campname as camp Committee, and not dereged. Return true once found. 
        //If not, student doesnt exist in that camp as Commitee. Return false.
        for(int i=0;i<allRegistrations.size();++i)
        {
            if(allRegistrations.get(i).getStudentName().equals(studentName) 
            && allRegistrations.get(i).getCampName().equals(campName)
            && allRegistrations.get(i).getRole().equals("Camp Committee")
            && !allRegistrations.get(i).getDeregistered())
            {
                return true;
            }
        }
        return false;
    }
}
