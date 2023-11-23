package camp;

import user.*;

/** 
 * Represents an interface to generate a camp report.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IGenerateStudentReport {
    /**
     * Outputs a report that contains camp details, and the list of students and their
     * specific roles in the camp to a text file. The implementor should 
     * Request for a file name, and generates a generic camp report for all camps that the user controls in that file,
     * using information from the associated Camp Database. 
     * @param user The user who wants to generate a report.
     * @param iSortCamps The user's sorting preferences.
     * @param iFilterCamps The user's filter-by category preferences.
     * @param filterString The exact string/values that the user wants to filter the category by.
     */
    public void generateStudentReport(User user, ISortCamps iSortCamps, IFilterCamps iFilterCamps, String filterString);
}
