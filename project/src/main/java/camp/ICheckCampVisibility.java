package camp;

/** 
 * Represents an interface to check within a camp database if a camp is visible.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface ICheckCampVisibility {
    /**
     * Checks a camp's visibility status from the associated camp database and returns the value accordingly.
     * @param campName The name of the camp of interest.
     * @return The visibility status of the camp.
     */
    public boolean isCampVisible(String campName);
}