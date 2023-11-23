package misc;

import camp.*;
import registration.*;

/** 
 * Represents a class whose sole purpose is to call the static function to initialise both Camp Databases and Registration 
 * databases to ensure both databases have the interfaces they require from each other.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CRDBInterfaceInitialiser {
        /**
         * Further initialises the various interfaces within both the camp database and the registration database. This method should be called instantly
         * after camp database and registration database objects have already been instantiated.
         * @param campDataBase The camp database object to be further initialised with registration database interfaces.
         * @param registrationDataBase THe registration database object to be further intiialised with camp database interfaces.
         */
    public static void InitialiseCRDataBaseInterfaces(CampDataBase campDataBase,
            RegistrationDataBase registrationDataBase) {
        registrationDataBase.InitialiseRegistrationDBManagers(campDataBase.getCampStudentSlotChecker(),
                campDataBase.getCampStudentSlotReducer(), campDataBase.getCheckSchoolMatch(),
                campDataBase.getCampStudentSlotIncreaser(), campDataBase.getClashWithRegisteredChecker(),
                campDataBase.getRegistrationClosedChecker(), campDataBase.getCampCommitteeSlotChecker(),
                campDataBase.getCampCommitteeSlotReducer(), campDataBase.getRegisteredCampsPrinter(),
                campDataBase.getCampVisibilityChecker());
        campDataBase.InitialiseCampDB(registrationDataBase.getAttendeeRegistrationChecker(),
                registrationDataBase.getCommitteeRegistrationChecker(),
                registrationDataBase.getRegisteredStudentNamesRolesGetter(),
                registrationDataBase.getListOfCampsIsCommiteeOfGetter());
    }
}
