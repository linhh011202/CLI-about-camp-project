package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

/** 
 * Represents an interface to obtain the remaining number of camp slots.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IGetCampSlots {

    /**
     * Gets a camp's remaining number of slots.
     * Implementing classes should take in a camp name and return a value representing the number 
     * of remaining slots, be it camp committee, attendee, total, or others.
     * @param campName The camp whose slots are of interest.
     * @return The remaining number of slots.
     */
    public int getCampSlots(String campName);
}