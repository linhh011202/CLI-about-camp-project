package camp;

/** 
 * Represents an interface to view all students and roles in a camp that a user is in charge of.
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IViewStudentList {  
    /**
     * Represents an interface that prints out the list of students and their respective roles for a camp that the staff owns.
     * 
     * @param staffName The name of the staff that is trying to print the list of students and roles.
     * @param campName The name of the camp the staff is trying to print the registered students for.
     */
    public void viewStudentList(String staffName, String campName);
}
