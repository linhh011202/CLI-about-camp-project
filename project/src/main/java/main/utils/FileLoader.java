package main.utils;

import java.io.FileReader;
import java.io.BufferedReader;

// We need this to handle if the file is not found
import java.io.IOException;
import java.util.ArrayList;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;
import main.user.DataList;

/** 
 * A File loader that reads in details about both staff and student user information from the respective csv files, and adds the objects into the user datalist.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-24
*/
public class FileLoader {
    /**
     * This FileLoader's predefined relative directory to load the student csv from.
     */
    public static final String STUDENT_PATH = "./student_list.csv"; 

    /**
     * This FileLoader's predefined relative directory to load the staff csv from.
     */
    public static final String STAFF_PATH = "./staff_list.csv";

    /**
     * This FileLoader's associated camp database, needed to provide the appropriate interfaces for the users to utilise.
     */
    private CampDataBase campDataBase;

    /**
     * This FileLoader's associated registration database, needed to provide the appropriate interfaces for the users to utilise.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * This FileLoader's associated user datalist, where the newly read-in and created user objects are stored, so they can be used in the main UI loop.
     */
    private DataList dataList;

    /**
     * Creates a new File Loader object with the corresponding databases.
     * @param campDataBase This FileLoader's associated camp database, needed to provide the appropriate interfaces for the users to utilise.
     * @param registrationDataBase This FileLoader's associated registration database, needed to provide the appropriate interfaces for the users to utilise.
     * @param dataList This FileLoader's associated user datalist, where the newly read-in and created user objects are stored, so they can be used in the main UI loop.
     */
    public FileLoader(CampDataBase campDataBase,RegistrationDataBase registrationDataBase,DataList dataList)
    {
        this.campDataBase=campDataBase;
        this.registrationDataBase=registrationDataBase;
        this.dataList=dataList;
    }

    /** 
     * This function reads the content of the .csv file and parse into the appropriate data structure (Student List/ Staff List)
     * We make sure that the file reading functionality works before we try to add into more complex class structure. 
     * It is a function used for testing functionality.
     * @param path is the path to the file
     * @return nothing because it is a void
     */
    public void readFile(String path){

        try{ // Try, catch structure to handle exception
            BufferedReader reader = new BufferedReader(new FileReader(path)); // Create a BufferedReader object
            String line = reader.readLine(); // This will give us the line string
            int count = 0;
            while (line != null) {
                if (count != 0){   // This logic remove the need for us to delete the first line. Just keep track of the count as we go down the line
                    if (line.isEmpty()) { // This will skip the empty line
                        continue;
                    }
                    //We want to split the line string into sub components
                    String[] lineComponents = line.split(","); // This will return an array of string
                    
                    // Since we have all the different components, let's print them in a different manner
                    System.out.print("Name: ");
                    System.out.print(lineComponents[0]);
                    System.out.print("\tEmail: ");
                    System.out.print(lineComponents[1]);
                    System.out.print("\tFaculty: "); // \t is a tab 
                    System.out.println(lineComponents[2]); // println will add a newline at the end. print will not add a newline
                    // System.out.println(line); // Comment this out to see the new printing
                }   // SO now the different components are nicely printed!

                count++; // Increment the count after reading the line
                line = reader.readLine();
            }
            
            reader.close();
        } catch (IOException e){
            System.out.println("File not found");
        }

    }



    /**
     * This function reads the file data, creates appropriate user objects, and adds them to the provided user list.
     * @param path The name of the file path
     * @param type The type of object this function is reading for. Student or Staff.
     * @param userList The userlist within the associated user DataList structure, either staff or student, depending on the input.
     */

    public void loadFile(String path, String type, ArrayList<User> userList){
        // This demonstrate the concept of POLYMORPHISM. I pass in the User[] Array because I don't know what to expect
        // But in the Main.java, I will pass the appropirate Student or Staff list, but they are children of User so it is valid
        // Now, copy and paste the parsing of the file


        try{ // Try, catch structure to handle exception
            BufferedReader reader = new BufferedReader(new FileReader(path)); // Create a BufferedReader object
            String line = reader.readLine(); // This will give us the line string
            while (line != null) {
                if (!(line.isBlank())) { 
                String[] lineComponents = line.split(","); // This will return an array of string
                
                if (type == "staff"){
                    Staff staff = new Staff(lineComponents[0].trim(),lineComponents[1],  Faculty.valueOf(lineComponents[2]),campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getSortManager().getSortCampByCampName(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getStaffStudentReportGenerator(),campDataBase.getListCampsStaffCreatedGetter(),dataList,campDataBase.getStaffPerformanceReportGenerator());// So here we need a constructor

                    //Check if staff already has data backed up previously. If so, we restore and use their previous data instead of creating a new
                    //Object
                    boolean alreadyExists=false;
                    for(int i=0;i<userList.size();++i)
                    {
                        if(userList.get(i).getName().equals(staff.getName()))
                        {
                            alreadyExists=true;
                        }
                    }
                    // Here we add to the list! If it didnt have backupdata.
                    if(!alreadyExists)
                    {
                        userList.add(staff); // The array list allows us to quickly add elements!
                    }    
                }
                else if (type == "student"){
                    Student student = new Student(lineComponents[0].trim(), lineComponents[1], Faculty.valueOf(lineComponents[2]),campDataBase.getStudentViewAllCamps(),campDataBase.getSortManager().getSortCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer(),registrationDataBase.getCommitteeCampRegisterer(),registrationDataBase.getStudentRegisteredCampsViewer(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getCampComStudentReportGenerator(),dataList);// So here we need a constructor
                    //Check if student already has data backed up previously. If so, we restore and use their previous data instead of creating a new
                    //Object
                    boolean alreadyExists=false;
                    for(int i=0;i<userList.size();++i)
                    {
                        if(userList.get(i).getName().equals(student.getName()))
                        {
                            alreadyExists=true;
                        }
                    }
                    // Here we add to the list! If it didnt have backupdata.
                    if(!alreadyExists)
                    {
                        userList.add(student);
                    }
                }
                else{
                    System.out.println("Invalid type");
                }}
                line = reader.readLine();
            }  // Always check your logic. Especially the parsing of the string
            reader.close();
        } catch (IOException e){
            System.out.println("File not found");
        }


    }


    }

