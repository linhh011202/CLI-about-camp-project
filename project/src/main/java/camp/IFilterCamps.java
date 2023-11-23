package camp;

/** 
 * Represents an interface to set the filter bits of all camps within a camp database based on the filter string.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IFilterCamps {
    /**
     * Represents an interface that sets the filter bits of all the camps in a camp database in a manner defined by the implementor.
     * Implementors should be associated with a camp database, and set the filter bits of the camps in the database
     * according to whether it matches the filter string, or not.
     * @param filterString The string to filter and find in the various camp information categories.
     */
    public void filterCamps(String filterString);
}
