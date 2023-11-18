package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that creates a camp within the camp database associated with this StaffCampCreator.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StaffCampCreator implements ICreateCamp {
    /**
     * The Camp Database that this StaffCampCreator manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new StaffCampCreator with the given Camp Database.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This StaffCampCreator's associated Camp Database.
     */
    public StaffCampCreator(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public void createCamp(String campName, String startDate, String endDate, String regClosingDate, boolean visibility,
            String location, int attendeeSlots, int campComSlots, String description, User user, Faculty openTo) {
        // Possible error checking if its not a staff?? But dont think we need it since
        // there shouldn't be a place in the mainApp
        // where non-staffs can even call this func
        
        Camp newCamp = new Camp(campName, startDate, endDate, regClosingDate, visibility, location, attendeeSlots,
                campComSlots, description, user, openTo);

        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        allCamps.add(newCamp);

    }
}