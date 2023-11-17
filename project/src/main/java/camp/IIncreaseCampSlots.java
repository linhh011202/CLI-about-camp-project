package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

/** 
 * Represents an interface to increase the remaining number of camp slots of a camp in a database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IIncreaseCampSlots {
    /**
     * Increases a camp's remaining number of slots. Implementing classes should take in a camp name and increment the
     * remaining number slots, for the corresponding camp in the camp database, be it camp committee, attendee, total, or others.
     * @param CampName The camp to have its slots reduced.
     */
    public void increaseCampSlots(String CampName);
}