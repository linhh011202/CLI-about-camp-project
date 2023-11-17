package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

/** 
 * Represents a class that helps to check if a student's faculty matches with the camp's faculty in the associated camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CheckSchoolMatch implements ICheckSchoolMatch {
    /**
     * The Camp Database that this CheckSchoolMatch manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new CheckSchoolMatch with the given Camp Database.
     * @param campDataBase This CheckSchoolMatch's associated Camp Database.
     */
    public CheckSchoolMatch(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public boolean checkSchoolMatch(Student student, String campName) {
        // Try to find camp. If found, check if its open to the student's school.
        for (int i = 0; i < campDataBase.getAllCamps().size(); ++i) {
            if (campDataBase.getAllCamps().get(i).getCampName().equals(campName)) {
                if (student.getFaculty() == campDataBase.getAllCamps().get(i).getOpenTo()
                        || campDataBase.getAllCamps().get(i).getOpenTo() == Faculty.NTU) {
                    return true;
                } else {
                    System.out.println("That camp is not open to students from your school!");
                    return false;
                }
            }
        }

        // Camp doesnt exist. Cant match.
        System.out.println("Could not find Camp!");
        return false;
    }
}
