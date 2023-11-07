package camp;

public class Main {
    public static void main(String[] args) 
    {
        CampDataBase campDataBase=new CampDataBase();
        RegistrationDataBase registrationDataBase=new RegistrationDataBase(campDataBase.getCampStudentSlotChecker(), campDataBase.getCampStudentSlotReducer());

        Staff currentStaff=new Staff("animal",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getFilterManager().getFilterCampByCampName());
        currentStaff.createCamp("c", "01/12/1000","10/12/6000", "01/10/2050", true, "CLASSSY", 2, 2, "ZEST CAMP" , Faculty.NTU);

        Staff nextStaff=new Staff("notanimal",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getFilterManager().getFilterCampByCampName());
        nextStaff.createCamp("b", "01/12/1990", "10/12/2000","01/10/2010", true, "ALIBABA", 10, 1, "BEST CAMP" , Faculty.SCSE);
        nextStaff.createCamp("a", "01/12/2050","10/12/1000", "01/10/2012", true, "MOHOR B", 5, 3, "AEST CAMP" , Faculty.SCSE);
        



        /* Test editing functions and viewing functions
        nextStaff.viewAllCamps();
        nextStaff.changeAttendeeSlots("b", 200);
        nextStaff.changeCampComSlots("b", 10);
        nextStaff.changeAttendeeSlots("a", 1);
        nextStaff.changeCampComSlots("a", 1);
        nextStaff.viewAllCamps();
        */


        /* test filter functions
        Student student=new Student("TOMMY",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getFilterManager().getFilterCampByCampName());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByStartDate());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByEndDate());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByRegDate());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getfilterCampByVisibility());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByTotalSlots());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByDescription());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByOpenTo());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByStaffIC());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeSlots());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableAttendeeSlots());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableCampCommiteeSlots());
        student.viewAllCamps();
        */
        

    }
}