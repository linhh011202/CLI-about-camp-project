package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;
import java.util.Arrays;

/** 
 * Represents an class that manages the registration database and allows clients to provide a student name, and request for a list containing a list of Strings that
 * contains information on the camp name, and the corresponding role of the student in that camp.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class RegisteredCampNamesRolesGetter implements IGetCampNamesRolesRegistered {
    /**
     * The registration database that this RegisteredCampNamesRolesGetter is managing.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * Creates a new RegisteredCampNamesRolesGetter with its associated registration database.
     * This constructor should be called and RegisteredCampNamesRolesGetter should be created automatically upon instantiation of
     * a {@link RegistrationDataBase}, or if not, a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This RegisteredCampNamesRolesGetter's associated registration database.
     */
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
