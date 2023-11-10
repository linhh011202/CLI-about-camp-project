package camp;

public class CRDBInterfaceInitialiser {
    public static void InitialiseCRDataBaseInterfaces(CampDataBase campDataBase,RegistrationDataBase registrationDataBase)
    {
        registrationDataBase.InitialiseRegistrationDBManagers(campDataBase.getCampStudentSlotChecker(), campDataBase.getCampStudentSlotReducer(),campDataBase.getCheckSchoolMatch(),campDataBase.getCampStudentSlotIncreaser(),campDataBase.getClashWithRegisteredChecker(),campDataBase.getRegistrationClosedChecker(),campDataBase.getCampCommitteeSlotChecker(),campDataBase.getCampCommitteeSlotReducer(),campDataBase.getRegisteredCampsPrinter(),campDataBase.getCampVisibilityChecker());
        
        campDataBase.getFilterManager().initialiseFilterManager(registrationDataBase.getAttendeeRegistrationChecker(),registrationDataBase.getCommitteeRegistrationChecker());
    }
}
