package registration;

import misc.CRDBInterfaceInitialiser;
import java.util.ArrayList;

/** 
 * Represents an class that manages the registration database and allows clients to change the camp names of all registration entries with an old camp name.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class RegistrationCampNamesChanger implements IChangeRegistrationCampNames
{
     /**
     * This RegistrationCampNamesChanger's associated registration database.
     */
    RegistrationDataBase registrationDataBase;

    /**
     * Creates a new RegistrationCampNamesChanger with the registration database that it manages, and the interface from
     * Camp database that it requires to increase the number of available camp attendee slots. The registration database will 
     * call this constructor and input itself as the paramter upon initialisation, or if not, a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This RegistrationCampNamesChanger's associated registration database.
     */
    RegistrationCampNamesChanger(RegistrationDataBase registrationDataBase)
    {
        this.registrationDataBase=registrationDataBase;
    }

    public void changeRegistrationCampNames(String campName, String newCampName)
    {
        ArrayList<Registration> allRegistrations=registrationDataBase.getAllRegistrations();

        for(int i=0;i<allRegistrations.size();++i)
        {
            if(allRegistrations.get(i).getCampName().equals(campName))
            {
                allRegistrations.get(i).setCampName(newCampName);
            }
        }
    }


}