package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class StudentRegisteredCampsViewer implements IViewRegisteredCamps {
    private RegistrationDataBase registrationDataBase;
    private IGetCampNamesRolesRegistered registeredCampNamesRolesGetter;
    private IPrintRegisteredCamps registeredCampsPrinter;

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
