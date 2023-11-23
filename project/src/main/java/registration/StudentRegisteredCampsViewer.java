package registration;

import camp.*;
import misc.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents an class that manages the registration database and allows clients to view all the camp details that
 * a student has registered for, as well as his corresponding.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StudentRegisteredCampsViewer implements IViewRegisteredCamps {
    /**
     * This StudentRegisteredCampViewer's associated registration database.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * Interface that this StudentRegisteredCampViewer uses to obtain all the roles and camp names that a student has registered for.
     */
    private IGetCampNamesRolesRegistered registeredCampNamesRolesGetter;

    /**
     * Interface that this StudentRegisteredCampViewer uses to print the camp details and corresponding student roles.
     */
    private IPrintRegisteredCamps registeredCampsPrinter;

    /**
     * Creates a new StudentRegisteredCampsViewer with its associated registration database and interfaces required to 
     * perform its method functions successfully. These interfaces are obtained from the CampDataBase and this constructor should
     * automatically be called upon the creation of a {@link RegistrationDataBase} or if not, after using the static method from {@link CRDBInterfaceInitialiser}.
     * @param registrationDataBase This StudentRegisteredCampsViewer's associated registration database.
     * @param registeredCampNamesRolesGetter Interface obtained from RegistrationDatabase that this StudentRegisteredCampViewer uses to obtain all the roles and camp names that a student has registered for.
     * @param registeredCampsPrinter Interface obtained from CampDataBase that this StudentRegisteredCampViewer uses to print the camp details and corresponding student roles.
     */
    public StudentRegisteredCampsViewer(RegistrationDataBase registrationDataBase,
            IGetCampNamesRolesRegistered registeredCampNamesRolesGetter, IPrintRegisteredCamps registeredCampsPrinter) {
        this.registrationDataBase = registrationDataBase;
        this.registeredCampNamesRolesGetter = registeredCampNamesRolesGetter;
        this.registeredCampsPrinter = registeredCampsPrinter;
    }

    public void viewRegisteredCamps(Student student, ISortCamps iSortCamps, IFilterCamps iFilterCamps,
            String filterString) {
        // Get string 2Darray of all camps registered under student from
        // RegistrationDatabase, and respective roles,
        // and query the CampDataBase to print those details in the user's sorted order.

        ArrayList<ArrayList<String>> campRoleArray = registeredCampNamesRolesGetter
                .getRegisteredCampNamesRoles(student.getName());

        // Check that user has registered camps
        if (campRoleArray.size() == 0) {
            System.out.println("You have no registered camps!");
            return;
        }

        // Use dependency of iSortCamps to sort the camps in the database according to
        // user's preferences before printing.
        iSortCamps.sortCamps();

        // Sets filtered bits
        iFilterCamps.filterCamps(filterString);

        // Print the camps and the user's roles.
        registeredCampsPrinter.printRegisteredCamps(campRoleArray);

    }

}
