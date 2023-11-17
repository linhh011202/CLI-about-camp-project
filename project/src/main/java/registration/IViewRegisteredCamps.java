package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

/** 
 * Represents an interface that allows a student to interact with the associated registration database to print
 * the details of all his registered camps.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IViewRegisteredCamps {
    /**
     * Prints out the details of all the camps that a student has registered for.
     * The implementor should utilise the sorting, filtering interfaces in the parameters to sort and filter the camps accordingly
     * before printing out the camps for the student to view.
     * @param student The student who wants to view all the camps he has registered for.
     * @param iSortCamps The sorting interface that can be used to sort the camps in the camp database.
     * @param iFilterCamps The filtering interface that can be used to filter the camps in the camp database.
     * @param filterString The filter string that should be used with the filtering interface to filter the camps.
     */
    public void viewRegisteredCamps(Student student, ISortCamps iSortCamps, IFilterCamps iFilterCamps,
            String filterString);
}
