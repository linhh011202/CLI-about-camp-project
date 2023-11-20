package main.utils;

// We need a Class to load the file, this comes from the Java library
// Search online to see what library
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

public class FileLoader {
    public static final String STUDENT_PATH = "./student_list.csv"; // Define where to load the file
    public static final String STAFF_PATH = "./staff_list.csv";

    private CampDataBase campDataBase;
    private RegistrationDataBase registrationDataBase;
    private DataList dataList;

    public FileLoader(CampDataBase campDataBase,RegistrationDataBase registrationDataBase,DataList dataList)
    {
        this.campDataBase=campDataBase;
        this.registrationDataBase=registrationDataBase;
        this.dataList=dataList;
    }

    // This thing is Javadoc!
    /***
     * This function read the content of the .csv file and parse into the appropriate data structure (Student List/ Staff List)
     * We make sure that the file reading functionality works before we try to add into more complex class structure
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


    // Remember to do javadoc as you code so that you can understand, and it is also one of the requirement
    // Start by typing / follow by 3 *** and it will auto generate

    /***
     * This function load the file into the appropriate data structure
     * @param path file path
     * @param userList the appropriate list
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
                    // Here we add to the list!
                    userList.add(staff); // The array list allows us to quickly add elements!
                }
                else if (type == "student"){
                    Student student = new Student(lineComponents[0].trim(), lineComponents[1], Faculty.valueOf(lineComponents[2]),campDataBase.getStudentViewAllCamps(),campDataBase.getSortManager().getSortCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer(),registrationDataBase.getCommitteeCampRegisterer(),registrationDataBase.getStudentRegisteredCampsViewer(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getCampComStudentReportGenerator(),dataList);// So here we need a constructor
                    userList.add(student);
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

