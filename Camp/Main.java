package camp;

public class Main {
    public static void main(String[] args) 
    {
        CampDataBase campDataBase=new CampDataBase();
        Staff currentStaff=new Staff("animal",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getFilterManager().getFilterCampByCampName());
        currentStaff.createCamp("c", "01/12/1000","10/12/6000", "01/10/2050", true, "CLASSSY", 2, 2, "ZEST CAMP" , Faculty.NTU);

        Staff nextStaff=new Staff("notanimal",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getFilterManager().getFilterCampByCampName());
        nextStaff.createCamp("b", "01/12/1990", "10/12/2000","01/10/2010", true, "ALIBABA", 10, 1, "BEST CAMP" , Faculty.SCSE);
        nextStaff.createCamp("a", "01/12/2050","10/12/1000", "01/10/2012", true, "MOHOR B", 5, 3, "AEST CAMP" , Faculty.SCSE);
        /* staff test cases
        nextStaff.changeVisibility("b",false);//makes one not visible to test if sorting by visibility works.

        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByStartDate());
        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByEndDate());
        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByRegDate());
        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getfilterCampByVisibility());
        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByTotalSlots());
        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByDescription());
        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByOpenTo());
        nextStaff.viewAllCamps();
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByStaffIC());
        nextStaff.viewAllCamps();
        */



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

        

    }
}