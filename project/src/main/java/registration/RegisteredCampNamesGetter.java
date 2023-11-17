package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents an class that manages the registration database and allows clients to request for a list of camp names that
 * a student has registered for, regardless of role in the registration database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class RegisteredCampNamesGetter implements IGetCampsRegistered {
    /**
     * The registration database that this RegisteredCampNamesGetter is managing.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * Creates a new RegisteredCampNamesGetter with its associated registration database.
     * This constructor should be called and RegisteredCampNamesGetter should be created automatically upon instantiation of
     * a {@link RegistrationDataBase}, or if not, a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This RegisteredCampNamesGetter's associated registration database.
     */
    public RegisteredCampNamesGetter(RegistrationDataBase registrationDataBase) {
        this.registrationDataBase = registrationDataBase;
    }

    public ArrayList<String> getRegisteredCampNames(String studentName) {
        ArrayList<String> registeredCamps = new ArrayList<String>(0);
        ArrayList<Registration> allRegistration = registrationDataBase.getAllRegistrations();

        for (int i = 0; i < allRegistration.size(); ++i) {
            // Find all entries that student is registered in, regardless of role, and add
            // to array. Then return array.
            if (allRegistration.get(i).getStudentName().equals(studentName)
                    && !allRegistration.get(i).getDeregistered()) {
                registeredCamps.add(new String(allRegistration.get(i).getCampName()));
            }
        }
        return registeredCamps;
    }

}
