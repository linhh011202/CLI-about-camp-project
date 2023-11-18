package user;

import java.util.ArrayList;

// Now I want to introduce you to this list class
// I want to store all type of list of the things the app has to manage
public class DataList {
    public ArrayList<User> studentList = new ArrayList<User>();
    public ArrayList<User> staffList = new ArrayList<User>();
    //Polymorphism will work here. SO the array can store User elements, and each element can be a Student or Staff
    
    // We have ArrayList that hold element of type Student. The Type of the element goes in between <> such as <Student>
    // The <> is called a generic type. It is a way to tell the compiler that this list will only hold element of type Student
    
    /*Student stuff */
    public boolean containsStudent (String username){



        for(User student: studentList){
            if(student.userID.equals(username)){
                return true; 
            }
        }
        return false; 


    }
    ////////////////////////////////////////////////
    public String getStudentPassword(String username){
        for(User student: studentList){
            if(student.userID.equals(username)){
                return student.password;
            }
        }
        return null; 
    }
    ///////////////////////////////////////////////////
         

    public String getStudentName(String username){
        for(User student: studentList){
            if(student.userID.equals(username)){
                return student.name;
            }
        }
        return null; 
         



    }
     /*end of student staff */
         /* now, staff stuff */

    public boolean containsStaff (String username){

        for(User staff: staffList){
            if(staff.userID.equals(username)){
                return true; 
            }
        }
        return false; 
    }
    //////////////////////////////////////////////////////
    public String getStaffPassword(String username){
        for(User staff: staffList){
            if(staff.userID.equals(username)){
                return staff.password;
            }
        }
        return null; 
    }
   
    public String getStaffName(String username){
        for(User staff: staffList){
            if(staff.userID.equals(username)){
                return staff.name;
            }
        }
        return null; 
         



    }

    





    
}




