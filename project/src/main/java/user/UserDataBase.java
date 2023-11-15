package user;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;

import java.util.ArrayList;

public class UserDataBase {
    private ArrayList<User> allUsers;

    public UserDataBase()
    {
        this.allUsers=new ArrayList<User>(0);
    }

    public ArrayList<User> getAllUsers(){return allUsers;}

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

    public void addUser(User user)
    {
        allUsers.add(user);
        return;
    }

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
