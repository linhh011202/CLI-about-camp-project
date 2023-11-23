package camp;

import misc.*;

import java.util.ArrayList;

/** 
 * Represents an class that takes in a list that holds the names of the registered camps, as well as the corresponding role of the student.
 * It then looks through the camp database and prints all details of those camps, as well as the role the student has in the camp.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class RegisteredCampsPrinter implements IPrintRegisteredCamps {
    /**
     * This RegisteredCampsPrinter's associated camp database.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new RegisteredCampsPrinter with the camp database that it is associated with.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This RegisteredCampsPrinter's associated database.
     */
    public RegisteredCampsPrinter(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public void printRegisteredCamps(ArrayList<ArrayList<String>> registeredCampsRoles) {
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        // Look through camps, check if its in registered camps list.
        // If found a matching one, print details, then print corresponding campRole.
        for (int i = 0; i < allCamps.size(); ++i) {
            for (int j = 0; j < registeredCampsRoles.size(); ++j) {
                if (allCamps.get(i).getCampName().equals(registeredCampsRoles.get(j).get(0)))// index 0 means campName
                                                                                             // of registered list,
                                                                                             // index 1 is corresponding
                                                                                             // role.
                {
                    // Only print if it's not filtered out.
                    if (!allCamps.get(i).getIsFilteredOut()) {
                        allCamps.get(i).printCamp();
                        System.out.printf(
                                "Your role in the above camp is %s.\n------------------------------------\n\n",
                                registeredCampsRoles.get(j).get(1));
                        break;
                    }
                }
            }
        }
        System.out.println("------------ End of list -----------");
    }

}
