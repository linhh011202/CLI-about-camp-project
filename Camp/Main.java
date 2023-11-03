package camp;

public class Main {
    public static void main(String[] args) 
    {
        CampDataBase campDataBase=new CampDataBase();
        Staff currentStaff=new Staff("name",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps());
        currentStaff.createCamp("one CAMP", "01/12/2012","10/12/2012", "01/10/2012", false, "JOHOR", 5, 2, "BEST CAMP" , Faculty.NTU);

        Staff nextStaff=new Staff("human",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps());
        nextStaff.createCamp("two CAMP", "01/12/2012", "10/12/2012","01/10/2012", false, "KOHOR", 5, 2, "BEST CAMP" , Faculty.SBS);
        nextStaff.createCamp("three CAMP", "01/12/2012","10/12/2012", "01/10/2012", false, "MOHOR B", 5, 2, "BEST CAMP" , Faculty.SCSE);
   
        nextStaff.changeCampName("two CAMP","GOOD CAMP");
        nextStaff.changeVisibility("GOOD CAMP",true);

        nextStaff.viewAllCamps();
        nextStaff.viewOwnCamps();

        currentStaff.viewOwnCamps();
        nextStaff.changeVisibility("three CAMP", true);
        currentStaff.changeVisibility("one CAMP", true);

        Student student=new Student("TOMMY",campDataBase.getStudentViewAllCamps(),Faculty.SCSE);
        student.viewAllCamps();

    }
}