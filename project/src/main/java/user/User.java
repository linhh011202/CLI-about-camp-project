package user;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;

/** 
 * Represents a user in the system. User is an abstract class and should be extended from.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public abstract class User {

    /**
     * This User's associated user database.
     */
    private UserDataBase userDataBase;

    /**
     * This User's name.
     */
    private String name;

    /**
     * This User's ISortCamps that determines his preferred sorting method, depending on what object is contained that implements
     * the ISortCamps.
     */
    private ISortCamps iSortCamps;

    /**
     * This User's filter string used to filter out specific camps.
     */
    private String filterString;

    /**
     * This User's IFilterCamps that determines which category he is filtering the camps by, depending on what object is contained that 
     * implements the IFilterCamps.
     */
    private IFilterCamps iFilterCamps;

    /**
     * This User's viewing camps interface that would affect the manner in which he views all camps, depending on what
     * object is contained that implements the IViewAllCamps.
     */
    private IViewAllCamps iViewAllCamps;

    /**
     * Creates a new User object with the given name, sorting and filtering styles, and viewing camp ability. Sorting and filtering
     * styles are default to be alphabetical, and no filter. The manner in which all camps are viewed is also
     * influenced by the class that implements it and is passed into the constructor parameters.
     * These interfaces can be obtained from {@link CampDataBase}.
     * @param name This User's name.
     * @param iSortCamps The sorting interface that can be used to sort the camps in the camp database.
     * @param iFilterCamps The filtering interface that can be used to filter the camps in the camp database.
     * @param userDataBase This User's associated user database.
     * @param iViewAllCamps The viewing camps interface that would be used to view all camps, and differ based on what type extends the user.
     */
    public User(String name, ISortCamps iSortCamps, IFilterCamps iFilterCamps, UserDataBase userDataBase,
            IViewAllCamps iViewAllCamps) {
        this.name = name;
        this.iSortCamps = iSortCamps; // default is by campName, maybe need to add some logic to set it to that if
                                      // there isnt any prexisting info in DB?
                                      // Or maybe in DB preset is alr Alpha so error checking should be here
                                      // anyways??..
        this.filterString = null;
        this.iFilterCamps = iFilterCamps;
        this.userDataBase = userDataBase;
        this.iViewAllCamps = iViewAllCamps;
    }

    /**
     * Gets this User's ISortCamps interface.
     * @return This User's ISortCamps interface.
     */
    public ISortCamps getSortCamps() {
        return iSortCamps;
    }

    /**
     * Changes this User's ISortCamps interface.
     * @param iSortCamps This User's new ISortCamps interface, obtained from {@link SortManager}
     */
    public void setCampSorter(ISortCamps iSortCamps) {
        this.iSortCamps = iSortCamps;
    }

    /**
     * Gets this User's IFilterCamps interface.
     * @return This User's IFilterCamps interface.
     */
    public IFilterCamps getFilterCamps() {
        return iFilterCamps;
    }

     /**
     * Changes this User's IFilterCamps interface.
     * @param iFilterCamps This User's new IFilterCamps interface, obtained from {@link FilterManager}
     */
    public void setCampFilter(IFilterCamps iFilterCamps) {
        this.iFilterCamps = iFilterCamps;
    }

    /**
     * Prints all the camps that the user is allowed to view.
     */
    public void viewAllCamps() {
        iViewAllCamps.viewAllCamps(this, getSortCamps(), getFilterCamps(), getFilterString());
    }

    /**
     * Gets this User's name.
     * @return This User's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get this User's filter string.
     * @return This User's filter string.
     */
    public String getFilterString() {
        return filterString;
    }

    /**
     * Changes this User's filter string.
     * @param filterString This User's new filter string.
     */
    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }

    /**
     * Get this User's associated user database.
     * @return This User's associated database.
     */
    public UserDataBase getUserDataBase() {
        return userDataBase;
    }

    /**
     * Get this User's view all camps interface.
     * @return This User's view all camps interface.
     */
    public IViewAllCamps getIViewAllCamps() {
        return iViewAllCamps;
    }

}
