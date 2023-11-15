package misc;

import camp;
import enquiries;
import registration;
import suggestions;
import user;

public class CRDBInterfaceInitialiser {
    public static void InitialiseCRDataBaseInterfaces(CampDataBase campDataBase,RegistrationDataBase registrationDataBase)
    {
        registrationDataBase.InitialiseRegistrationDBManagers(campDataBase.getCampStudentSlotChecker(), campDataBase.getCampStudentSlotReducer(),campDataBase.getCheckSchoolMatch(),campDataBase.getCampStudentSlotIncreaser(),campDataBase.getClashWithRegisteredChecker(),campDataBase.getRegistrationClosedChecker(),campDataBase.getCampCommitteeSlotChecker(),campDataBase.getCampCommitteeSlotReducer(),campDataBase.getRegisteredCampsPrinter(),campDataBase.getCampVisibilityChecker());
        campDataBase.InitialiseCampDB(registrationDataBase.getAttendeeRegistrationChecker(),registrationDataBase.getCommitteeRegistrationChecker(),registrationDataBase.getRegisteredStudentNamesRolesGetter(),registrationDataBase.getListOfCampsIsCommiteeOfGetter());
    }
}
