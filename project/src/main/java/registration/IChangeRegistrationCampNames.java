package registration;


/** 
 * Represents an interface that allows the client to change all camps with a chosen camp name, of the implementor classes's associated registration database, to a new camp name.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IChangeRegistrationCampNames {

    /**
     * Given an old camp name and a new camp name, the implementor changes the registration entries within its associated
     * registration database to a new camp name. Only to be called after the staff.changeCampName method returns true.
     * @param campName The old camp name to be changed.
     * @param newCampName The new camp name.
     */
    public void changeRegistrationCampNames(String campName, String newCampName);
}

