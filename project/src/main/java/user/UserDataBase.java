package user;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;

import java.util.ArrayList;

/** 
 * A User Database that stores all the existing users in the system.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class UserDataBase { 
    /**
     * This UserDataBase's list of all users.
     */
    private ArrayList<User> allUsers;

    /**
     * Creates a new UserDataBase with an empty list of all users.
     */
    public UserDataBase()
    {
        this.allUsers=new ArrayList<User>(0);
    }

    /**
     * Gets this UserDataBase's list of all users.
     * @return This UserDatabase's list of all users.
     */
    public ArrayList<User> getAllUsers(){return allUsers;}

    /**
     * Finds a user by name within the list of all users. It returns a null object on failure, or a user object if found.
     * @param name The name of student that is to be found within this User Database.
     * @return User object if user is found, or null if user with specified name cannot be found.
     */
    public User getUser(String name)
    {
        for(int i=0;i<allUsers.size();++i)
        {
            if(allUsers.get(i).getName().equals(name))
            {
                return allUsers.get(i);
            }
        }

        System.out.println("Error: No such user!");
        return null;
    }

    //Call whenever a student object becomes CampComm, so data in DB is updated as well.
    /**
     * Replaces a user object within this User Database's list of users. This should be used whenever a student registers to be a camp
     * committee member, because he is upgraded to a camp commmittee object. Hence this change should be reflected in the User DataBase as well.
     * 
     * <p>
     * Example: userDataBase.updateUser(currentUser.getName(),currentUser.registerCampCommittee("campName"));
     * </p>
     * 
     * @param name Name of the user object to be replaced.
     * @param user The new user object to replace the old user object.
     * @return The original user object that was passed in as a parameter.
     */
    public User updateUser(String name, User user)
    {
        for(int i=0;i<allUsers.size();++i)
        {
            if(allUsers.get(i).getName().equals(name))
            {
                allUsers.set(i,user);
                return user;
            }
        }
        System.out.println("Error: No such user!");
        return user;
    }

    /**
     * Adds a new user to this User Database's list of users.
     * @param user The new user to be added to this User Database.
     */
    public void addUser(User user)
    {
        allUsers.add(user);
        return;
    }

    /**
     * Given a user's name, finds the user and adds points to it. Will not add points if the user is not a camp commmittee member.
     * @param name Name of student to add points to.
     */
    public void addPoints(String name)
    {
        for(int i=0;i<allUsers.size();++i)
        {
            //If same name, check if its under student/campCom and NOT staff with instanceof. Then check if its campcom with the boolean flag.
            if(allUsers.get(i).getName().equals(name))
            {
                //check if it is campcom, then can downcast
                if(allUsers.get(i) instanceof CampCommittee && (((Student)(allUsers.get(i))).getIsCommittee()))
                {
                    CampCommittee campCommittee=(CampCommittee)(allUsers.get(i));
                    campCommittee.addPoints();
                    return;
                }
                
            }
        }
        System.out.println("No such camp committee member to add points to!");
        return;
    }

    /**
     * Gets the number of points that a user has. Only a camp committee member has points, and function will return -1 if it fails.
     * @param name Name of user whose points we want to attain.
     * @return Number of points. Returns -1 if user is not a camp committee member.
     */
    public int getPoints(String name)
    {
        for(int i=0;i<allUsers.size();++i)
        {
            //If same name, check if its under student/campCom and NOT staff with instanceof. Then check if its campcom with the boolean flag.
            if(allUsers.get(i).getName().equals(name))
            {
                //check if it is campcom, then can downcast
                if(allUsers.get(i) instanceof CampCommittee && (((Student)(allUsers.get(i))).getIsCommittee()))
                {
                    CampCommittee campCommittee=(CampCommittee)(allUsers.get(i));
                    return campCommittee.getPoints();
                }
                
            }
        }
        System.out.println("No such camp committee member to get points!");
        return -1;
    }
    
}
