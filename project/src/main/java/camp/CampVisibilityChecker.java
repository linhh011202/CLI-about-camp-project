package camp;

import misc.*;

/** 
 * Represents a class that helps to change the visibility status, given a camp name in the associated camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CampVisibilityChecker implements ICheckCampVisibility {
     /**
     * The Camp Database that this CampVisibilityChecker manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new CampVisibilityChecker with the given Camp Database.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This CampVisibilityChecker's associated Camp Database.
     */
    public CampVisibilityChecker(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public boolean isCampVisible(String campName) {
        // Check if camp is visible.
        for (int i = 0; i < campDataBase.getAllCamps().size(); ++i) {
            if (campDataBase.getAllCamps().get(i).getCampName().equals(campName)) {
                if (campDataBase.getAllCamps().get(i).getVisibility()) {
                    return true;
                } else {
                    System.out.println("Error! Unable to find camp.\n");
                    return false;
                }
            }
        }

        // Camp doesnt exist. return false.
        System.out.println("Error! Unable to find camp.\n");
        return false;
    }

}
