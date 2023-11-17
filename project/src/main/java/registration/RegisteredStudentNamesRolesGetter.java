package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;
import java.util.Arrays;

/** 
 * Represents an class that manages the registration database and allows clients to provide a camp name, and request for a list containing a list of Strings that
 * contains information on the student name, and the corresponding role of the student in that camp.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class RegisteredStudentNamesRolesGetter implements IGetStudentNamesRolesRegistered {
    /**
     * The registration database that this RegisteredStudentNamesRolesGetter is managing.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * Creates a new RegisteredStudentNamesRolesGetter with its associated registration database.
     * This constructor should be called and RegisteredStudentNamesRolesGetter should be created automatically upon instantiation of
     * a {@link RegistrationDataBase}, or if not, a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This RegisteredStudentNamesRolesGetter's associated registration database.
     */
    public RegisteredStudentNamesRolesGetter(RegistrationDataBase registrationDataBase) {
        this.registrationDataBase = registrationDataBase;
    }

    public ArrayList<ArrayList<String>> getRegisteredStudentNamesRoles(String campName) {
        ArrayList<ArrayList<String>> registeredStudentsRoles = new ArrayList<ArrayList<String>>(0);
        ArrayList<Registration> allRegistration = registrationDataBase.getAllRegistrations();

        for (int i = 0; i < allRegistration.size(); ++i) {
            // Find all students that have registered in the camp, add the studentName, and
            // corresponding role to arrayList.
            if (allRegistration.get(i).getCampName().equals(campName) && !allRegistration.get(i).getDeregistered()) {
                registeredStudentsRoles.add(new ArrayList<String>(
                        Arrays.asList(allRegistration.get(i).getStudentName(), allRegistration.get(i).getRole())));
            }
        }
        return registeredStudentsRoles;
    }
}
