package misc;

import camp.*;
import enquiries.*;
import registration.*;
import suggestions.*;
import user.*;

//NOT IN UMLYET

/** 
 * Represents a class that provides integer error codes as static final constants for easier reading in code.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class IntErrorCodes {
    /**
     * The error code if a camp is not found.
     */
    public static final int CAMP_NOT_FOUND = -1;

    /**
     * The error code if there are insufficient student attendee slots in a camp.
     */
    public static final int INSUFFICIENT_STUDENT_SLOTS = -2;

    /**
     * The error code if there are insufficient camp committee slots in a camp.
     */
    public static final int INSUFFICIENT_COMMITTEE_SLOTS = -3;
}
