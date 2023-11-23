package registration;

import user.*;

/** 
 * Represents an interface that registers a student to a camp, not including camp committee member. To register as camp committee member, see
 * {@link IRegisterCommittee}.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IRegisterCamp {
    /**
     * Registers a student to a camp, given the student name and camp name. Upon failure, the class that implements this interface should print an error message
     * and return. The class can also vary its implementation on the role it wants to assign to the student that is registering.
     * @param student Name of student to be registered to camp.
     * @param campName Name of camp that student should be registered to.
     */
    public void registerCamp(Student student, String campName);
}