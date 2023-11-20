package main.user;

import java.util.ArrayList;
import java.util.Scanner;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;
import java.io.*;

// Now I want to introduce you to this list class
// I want to store all type of list of the things the app has to manage
public class DataList {
    public ArrayList<User> studentList = new ArrayList<User>();
    public ArrayList<User> staffList = new ArrayList<User>();

    /**
     * This DataList's constructor, tries to read in any existing information that could have been stored from previous runs.
     */
    public DataList()
    {
        try
        {
            readStudentFromStorage();
            readStaffFromStorage();
        }
        catch(Exception e){
            ;
        }
    }

    //Polymorphism will work here. SO the array can store User elements, and each element can be a Student or Staff
    
    // We have ArrayList that hold element of type Student. The Type of the element goes in between <> such as <Student>
    // The <> is called a generic type. It is a way to tell the compiler that this list will only hold element of type Student
    

    //Generic stuff for fuunctionality merging

    //Call whenever a student object becomes CampComm, so data in DB is updated as well.
    /**
     * Replaces a user object within this User Database's list of users. This should be used whenever a student registers to be a camp
     * committee member, because he is upgraded to a camp commmittee object. Hence this change should be reflected in the User DataBase as well.
     * 
     * <p>
     * Example: dataList.updateUser(currentUser.getName(),currentUser.registerCampCommittee("campName"));
     * </p>
     * 
     * @param name Name of the user object to be replaced.
     * @param user The new user object to replace the old user object.
     * @return The original user object that was passed in as a parameter.
     */
    public User updateUser(String name, User user)
    {
        for(int i=0;i<studentList.size();++i)
        {
            if(studentList.get(i).getName().equals(name))
            {
                studentList.set(i,user);
                return user;
            }
        }

        for(int i=0;i<staffList.size();++i)
        {
            if(staffList.get(i).getName().equals(name))
            {
                staffList.set(i,user);
                return user;
            }
        }

        System.out.println("Error: No such user!");
        return user;
    }

    /**
     * Given a user's name, finds the user and adds points to it. Will not add points if the user is not a camp commmittee member.
     * @param name Name of student to add points to.
     */
    public void addPoints(String name)
    {
        for(int i=0;i<studentList.size();++i)
        {
            //If same name, check if its under student/campCom and NOT staff with instanceof. Then check if its campcom with the boolean flag.
            if(studentList.get(i).getName().equals(name))
            {
                //check if it is campcom, then can downcast
                if(studentList.get(i) instanceof CampCommittee && (((Student)(studentList.get(i))).getIsCommittee()))
                {
                    CampCommittee campCommittee=(CampCommittee)(studentList.get(i));
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
        for(int i=0;i<studentList.size();++i)
        {
            //If same name, check if its under student/campCom and NOT staff with instanceof. Then check if its campcom with the boolean flag.
            if(studentList.get(i).getName().equals(name))
            {
                //check if it is campcom, then can downcast
                if(studentList.get(i) instanceof CampCommittee && (((Student)(studentList.get(i))).getIsCommittee()))
                {
                    CampCommittee campCommittee=(CampCommittee)(studentList.get(i));
                    return campCommittee.getPoints();
                }
                
            }
        }
        System.out.println("No such camp committee member to get points!");
        return -1;
    }



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
                return student.getName();
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
                return staff.getName();
            }
        }
        return null; 
         



    }


    
    public User getStudent(String username){
        for(User student: studentList){
            if(student.userID.equals(username)){
                return student;
            }
        }
        return null; 
    }



    public User getStaff(String username){
        for(User staff: staffList){
            if(staff.userID.equals(username)){
                return staff;
            }
        }
        return null; 
    }

    // Method to set a new password for a student with user input
    public void setNewStudentPasswordWithInput(String username,String newPassword) {
        for (User student : studentList) {
            if (student.userID.equals(username)) {
                student.setPassword(newPassword);
                System.out.println("Password changed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Method to set a new password for a staff member with user input
    public void setNewStaffPasswordWithInput(String username, String newPassword) {
        for (User staff : staffList) {
            if (staff.userID.equals(username)) {
                staff.setPassword(newPassword);
                System.out.println("Password changed successfully.");
                return;
            }
        }
        System.out.println("Staff member not found.");
    }


    //Functions to read and write to file for storage and retrieval of information
    //Read and write to storage
    /**
     * Writes this DataList's array of student entries into a txt file. This should be called at the end of the
     * application in order to save the database into a file.
     * @throws IOException Throws an exception if it is unable to find the file to read or write to.
     */
    public void writeStudentToStorage() throws IOException {

        
        File directory = new File("project\\src\\StudentInfo");
    
        // Check if have directory, else create if needed
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        try (FileOutputStream fileOutputStream = new FileOutputStream("project\\src\\StudentInfo\\StudentInfo.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            for (int i = 0; i < studentList.size(); ++i) {
                objectOutputStream.writeObject(studentList.get(i));
            }
    
            objectOutputStream.flush();
        }
    }

    /**
     * Searches for the designated storage txt file to read in student list data from previous app runs, and adds those
     * student objects to the student list array this DataList database. If there is no storage file, does not read in anything and no new
     * student entries are added to the student array in this database.
     * @throws IOException Thrown if it is unable to find the file to read or write to.
     * @throws ClassNotFoundException Thrown if unable to find class that we are trying to reference.
     */
    public void readStudentFromStorage() throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream("project\\src\\StudentInfo\\StudentInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) 
        {
            while (fileInputStream.available() > 0) {
                Student student = (Student) objectInputStream.readObject();
                studentList.add(student);
            }
        }
    }

    /**
     * Writes this DataList's array of staff entries into a txt file. This should be called at the end of the
     * application in order to save the database into a file.
     * @throws IOException Throws an exception if it is unable to find the file to read or write to.
     */
    public void writeStaffToStorage() throws IOException {
        File directory = new File("project\\src\\DataBaseInformation\\StaffInfo");
    
        // Check if have directory, else create if needed
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        try (FileOutputStream fileOutputStream = new FileOutputStream("project\\src\\DataBaseInformation\\StaffInfo\\StaffInfo.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            for (int i = 0; i < staffList.size(); ++i) {
                objectOutputStream.writeObject(staffList.get(i));
            }
    
            objectOutputStream.flush();
        }
    }

    /**
     * Searches for the designated storage txt file to read in staff list data from previous app runs, and adds those
     * staff objects to the staff list array this DataList database. If there is no storage file, does not read in anything and no new
     * staff entries are added to the staff array in this database.
     * @throws IOException Thrown if it is unable to find the file to read or write to.
     * @throws ClassNotFoundException Thrown if unable to find class that we are trying to reference.
     */
    public void readStaffFromStorage() throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream("project\\src\\DataBaseInformation\\StaffInfo\\StaffInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) 
        {
            while (fileInputStream.available() > 0) {
                Staff staff = (Staff) objectInputStream.readObject();
                staffList.add(staff);
            }
        }
    }





    
}




