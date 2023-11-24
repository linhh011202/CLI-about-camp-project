package registration;

import misc.CRDBInterfaceInitialiser;
import java.util.ArrayList;

/** 
 * Represents an class that manages the registration database and allows clients to delete all registration entries with a specified camp name.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class RegistrationDeleter implements IDeleteRegistrations
{
     /**
     * This RegistrationDeleter's associated registration database.
     */
    RegistrationDataBase registrationDataBase;

    /**
     * Creates a new RegistrationDeleter with the registration database that it manages, and the interface from
     * Camp database that it requires to increase the number of available camp attendee slots. The registration database will 
     * call this constructor and input itself as the paramter upon initialisation, or if not, a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This RegistrationDeleter's associated registration database.
     */
    RegistrationDeleter(RegistrationDataBase registrationDataBase)
    {
        this.registrationDataBase=registrationDataBase;
    }

    public void deleteRegistrations(String campName)
    {
        ArrayList<Registration> allRegistrations=registrationDataBase.getAllRegistrations();

        for(int i=0;i<allRegistrations.size();++i)
        {
            if(allRegistrations.get(i).getCampName().equals(campName))
            {
                allRegistrations.remove(i);
                //Next registration entry would move down, so we decrement to ensure we check it as well.
                --i;
            }
        }
    }
}
