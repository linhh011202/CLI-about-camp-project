package registration;

import camp;
import enquiries;
import misc;
import suggestions;
import user;

import java.util.ArrayList;
import java.util.Arrays;

public class RegisteredStudentNamesRolesGetter implements IGetStudentNamesRolesRegistered
{
    private RegistrationDataBase registrationDataBase;

    public RegisteredStudentNamesRolesGetter(RegistrationDataBase registrationDataBase)
    {
        this.registrationDataBase=registrationDataBase;
    }


    public ArrayList<ArrayList<String>> getRegisteredStudentNamesRoles(String campName)
    {
        ArrayList<ArrayList<String>> registeredStudentsRoles=new ArrayList<ArrayList<String>>(0);
        ArrayList<Registration> allRegistration=registrationDataBase.getAllRegistrations();

        for(int i=0;i<allRegistration.size();++i)
        {
            //Find all students that have registered in the camp, add the studentName, and corresponding role to arrayList.
            if(allRegistration.get(i).getCampName().equals(campName) && !allRegistration.get(i).getDeregistered())
            {
                registeredStudentsRoles.add(new ArrayList<String>(Arrays.asList(allRegistration.get(i).getStudentName(), allRegistration.get(i).getRole())));
            }
        }
        return registeredStudentsRoles;
    }
}
