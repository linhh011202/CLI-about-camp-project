package camp;

/** 
 * Represents an interface to check within a camp database if a camp's registration date has passed.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface ICheckRegistrationClosed {
    /**
     * Checks within the associated camp database if a specific camp's registration deadline has closed.
     * @param campName The camp to check the deadline for.
     * @return True if registration has closed, False if registration is still open.
     */
    public boolean isRegistrationClosed(String campName);
}