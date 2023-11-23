package camp;

import user.*;
import main.user.DataList;

/** 
 * Represents an interface to generate a performance report of the camp committee members of the camps that the staff is
 * in charge of.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IGeneratePerformanceReport {
    /**
     * Represents an interface that creates a performance report in a text file. 
     * The implementor is responsible for asking for the file name, and utilise the sorting and filtering interfaces together with the filterString to sort and filter the camps in it's associated camp database first, to find the suitable camps
     * that need to be output in the report.
     * @param dataList A User Data base object to obtain the user's points from.
     * @param user The user who wants to generate a report.
     * @param iSortCamps The user's sorting preferences.
     * @param iFilterCamps The user's filter-by category preferences.
     * @param filterString The exact string/values that the user wants to filter the category by.
     */
    public void generatePerformanceReport(DataList dataList, User user, ISortCamps iSortCamps,
            IFilterCamps iFilterCamps, String filterString);
}
