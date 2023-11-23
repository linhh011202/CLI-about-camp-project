package camp;

import user.*;

/** 
 * Represents an interface to view all camps that a user is allowed to see in a camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IViewAllCamps {
    /**
     * Represents an interface that prints out the details of all the camps that a user is allowed to view.
     * The implementor should utilise the sorting, filtering interfaces in the parameters to sort and filter the camps accordingly
     * before printing out the camps for the user to view.
     * @param user The user who wants to view all the camps available to them.
     * @param iSortCamps The sorting interface that can be used to sort the camps in the camp database.
     * @param iFilterCamps The filtering interface that can be used to filter the camps in the camp database.
     * @param filterString The filter string that should be used with the filtering interface to filter the camps.
     */
    public void viewAllCamps(User user, ISortCamps iSortCamps, IFilterCamps iFilterCamps, String filterString);
}