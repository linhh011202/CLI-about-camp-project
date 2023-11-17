package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents an class that searches within a camp database and returns a list of camps that a staff has created.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class ListCampsStaffCreatedGetter implements IGetCampsCreated {
    /**
     * This ListCampsStaffCreatedGetter's associated camp database.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new ListCampsStaffCreatedGetter with the camp database it is associated with.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This ListCampsStaffCreatedGetter's associated camp database.
     */
    public ListCampsStaffCreatedGetter(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public ArrayList<String> getListCampStaffCreated(String staffName) {
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        ArrayList<String> campsStaffCreated = new ArrayList<String>(0);

        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getStaffInCharge().equals(staffName)) {
                campsStaffCreated.add(allCamps.get(i).getCampName());
            }
        }
        return campsStaffCreated;
    }

}
