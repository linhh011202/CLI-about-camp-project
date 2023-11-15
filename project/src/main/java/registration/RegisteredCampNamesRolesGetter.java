package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;
import java.util.Arrays;

public class RegisteredCampNamesRolesGetter implements IGetCampNamesRolesRegistered {
    private RegistrationDataBase registrationDataBase;

    public RegisteredCampNamesRolesGetter(RegistrationDataBase registrationDataBase) {
        this.registrationDataBase = registrationDataBase;
    }

    public ArrayList<ArrayList<String>> getRegisteredCampNamesRoles(String studentName) {
        ArrayList<ArrayList<String>> registeredCampsRoles = new ArrayList<ArrayList<String>>(0);
        ArrayList<Registration> allRegistration = registrationDataBase.getAllRegistrations();

        for (int i = 0; i < allRegistration.size(); ++i) {
            // Find all entries that student is registered in, add the campName, and
            // corresponding role to arrayList.
            if (allRegistration.get(i).getStudentName().equals(studentName)
                    && !allRegistration.get(i).getDeregistered()) {
                registeredCampsRoles.add(new ArrayList<String>(
                        Arrays.asList(allRegistration.get(i).getCampName(), allRegistration.get(i).getRole())));
            }
        }
        return registeredCampsRoles;
    }
}
