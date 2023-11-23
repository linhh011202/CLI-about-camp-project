package registration;

import user.*;

//To utilise the method to register as campCom, you must assign the old student reference to its return value.
//This is to allow the returning of a promoted CampCom object, or the Student Object again(only if function fails to register as campCom)
//Use as such: 
//Student student=new Student(insert constructor)
//student=student.registerCampCommittee(campName)
//must assign return value to old student reference

/** 
 * Represents an interface that registers a student to a Camp as a camp committee member.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IRegisterCommittee {
    /**
     * This method attemps to register a student to a camp as a campcommittee member, and adds the registration details to the
     * associated registration database. Upon failure, it would return the original student reference. Upon success, it should return
     * a promoted CampCommittee object that is created within the implementing class.
     * 
     * <p>
     * One way this can be done by providing default values
     * to the CampCommittee specific variables, while using the original student object to copy-construct into the rest of the camp committee object.
     * </p>
     * 
     * @param student The student that wants to register as a camp committee member.
     * @param campName The name of the camp that the student wants to register for.
     * @return A student reference. It would be the same student object that was passed into it on failure. On success, it would be a 
     * promoted CampCommittee object with otherwise the same attributes as the student object that was passed in. 
     */
    public Student registerCamp(Student student, String campName);
}