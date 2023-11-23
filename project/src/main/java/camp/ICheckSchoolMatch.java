package camp;

import user.*;

/** 
 * Represents an interface to check within a camp database if a camp is indeed open to a student's faculty.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface ICheckSchoolMatch {
    /**
     * Checks if a camp is open to a student based on their faculties.
     * @param student The student of interest.
     * @param CampName The camp of interest.
     * @return True if the student's faculty matches the camp. Otherwise false is returned.
     */
    public boolean checkSchoolMatch(Student student, String CampName);
}