package camp;

public class Main {
    public static void main(String[] args) 
    {
        CampDataBase campDataBase=new CampDataBase();
        Staff currentStaff=new Staff("goat",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps());
        currentStaff.createCamp("FAT CAMP", "011212","101212", "011012", false, "JOHOR", 5, 2, "BEST CAMP" , Faculty.NTU);

        Staff nextStaff=new Staff("IDIOT",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps());
        nextStaff.createCamp("BIG CAMP", "011212", "101212","011012", false, "KOHOR", 5, 2, "BEST CAMP" , Faculty.SBS);
        nextStaff.createCamp("TRASH CAMP", "011212","101212", "011012", false, "MOHOR B", 5, 2, "BEST CAMP" , Faculty.SCSE);
   
        nextStaff.changeCampName("TRASH CAMP","BEASTLY CAMP");
        nextStaff.changeVisibility("BIG CAMP",true);

        nextStaff.viewAllCamps();
        nextStaff.viewOwnCamps();

        currentStaff.viewOwnCamps();
        nextStaff.changeVisibility("BEASTLY CAMP", true);
        currentStaff.changeVisibility("FAT CAMP", true);

        Student student=new Student("TOMMY",campDataBase.getStudentViewAllCamps(),Faculty.SCSE);
        student.viewAllCamps();

    }
}