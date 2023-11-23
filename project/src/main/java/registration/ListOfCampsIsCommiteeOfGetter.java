package registration;

import misc.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents an class that manages the registration database and allows clients to request for a list of camps that
 * a student has registered as a committee member of in the registration database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class ListOfCampsIsCommiteeOfGetter implements IGetCampsIsCommittee {
    /**
     * The registration database that this ListOfCampsIsCommiteeOfGetter is managing.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * Creates a new ListOfCampsIsCommiteeOfGetter with its associated registration database.
     * This constructor should be called and ListOfCampsIsCommiteeOfGetter should be created automatically upon instantiation of
     * a {@link RegistrationDataBase}, or if not, a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This ListOfCampsIsCommiteeOfGetter's associated registration database.
     */
    public ListOfCampsIsCommiteeOfGetter(RegistrationDataBase registrationDataBase) {
        this.registrationDataBase = registrationDataBase;
    }

    public ArrayList<String> getCampsIsCommittee(Student student) {
        ArrayList<String> campListIsCommittee = new ArrayList<String>(0);

        ArrayList<Registration> allRegistrations = registrationDataBase.getAllRegistrations();
        for (int i = 0; i < allRegistrations.size(); ++i) {
            if (allRegistrations.get(i).getStudentName().equals(student.getName())
                    && allRegistrations.get(i).getRole().equals("Camp Committee")
                    && !allRegistrations.get(i).getDeregistered()) {
                campListIsCommittee.add(allRegistrations.get(i).getCampName());
            }
        }

        return campListIsCommittee;
    }
}
