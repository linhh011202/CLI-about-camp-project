package camp;

import java.util.ArrayList;

public class RegisteredCampNamesGetter implements IGetCampsRegistered
{
    private RegistrationDataBase registrationDataBase;

    public RegisteredCampNamesGetter(RegistrationDataBase registrationDataBase)
    {
        this.registrationDataBase=registrationDataBase;
    }
    public ArrayList<String> getRegisteredCampNames(String studentName)
    {
        ArrayList<String> registeredCamps=new ArrayList<String>(0);
        ArrayList<Registration> allRegistration=registrationDataBase.getAllRegistrations();

        for(int i=0;i<allRegistration.size();++i)
        {
            //Find all entries that student is registered in, regardless of role, and add to array. Then return array.
            if(allRegistration.get(i).getStudentName().equals(studentName) && !allRegistration.get(i).getDeregistered())
            {
                registeredCamps.add(new String(allRegistration.get(i).getCampName()));
            }
        }
        return registeredCamps;
    }
   
}

