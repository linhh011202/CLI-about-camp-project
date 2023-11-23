package main;

import java.util.Scanner;

import main.utils.*; 

import main.user.DataList; // Import DataList definition
import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

/** 
 * A Camp Application for staff and students to manage, view and register for
 * camps within NTU. The application will act as a centralized hub for all staff and 
 * students.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-24
*/
public class Main {

    /**
     * The entry point of the camp application.
     * @param args Command Line arguments, we do not use them in this app.
     */
    public static void main(String[] args) { 

        //Initialise databases
        System.out.println("Restoring information from previous runs...");
        SuggestionsDB suggestionsDB=new SuggestionsDB();
        CampDataBase campDataBase=new CampDataBase();
        RegistrationDataBase registrationDataBase=new RegistrationDataBase();
        CRDBInterfaceInitialiser.InitialiseCRDataBaseInterfaces(campDataBase, registrationDataBase);
        EnquiriesDB enquiriesDB=new EnquiriesDB(campDataBase.getCheckSchoolMatch(),campDataBase.getCampVisibilityChecker());
        DataList dataList = new DataList(); // User database
        FileLoader fileLoader=new FileLoader(campDataBase,registrationDataBase,dataList);
        fileLoader.loadFile(FileLoader.STUDENT_PATH, "student", dataList.studentList);// We want to load the student
                                                                                      // file into the student list
        fileLoader.loadFile(FileLoader.STAFF_PATH, "staff", dataList.staffList);// We want to load the staff file into
                                                                                // the staff list

        //Initialise all objects with appropriate interfaces.
        for(int i=0;i<dataList.studentList.size();++i)
        {
            ((Student)(dataList.studentList).get(i)).initialiseAfterDeserialise(campDataBase.getStudentViewAllCamps(),campDataBase.getSortManager().getSortCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer(),registrationDataBase.getCommitteeCampRegisterer(),registrationDataBase.getStudentRegisteredCampsViewer(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getCampComStudentReportGenerator(),dataList);
        }

        for(int i=0;i<dataList.staffList.size();++i)
        {
            ((Staff)(dataList.staffList).get(i)).initialiseAfterDeserialise(campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getSortManager().getSortCampByCampName(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getStaffStudentReportGenerator(),campDataBase.getListCampsStaffCreatedGetter(),dataList,campDataBase.getStaffPerformanceReportGenerator());
        }


        Scanner scanner = new Scanner(System.in);
        Login login = new Login(scanner);
        CommandParser commandParser = new CommandParser(suggestionsDB,campDataBase,registrationDataBase,enquiriesDB,dataList);

        while (true) {
            try {
                String username = login.startLogin(dataList);
                // exit
                
                if (username.equals("exit")) {
                    //Everytime they program is closed, save database infos to file.
                    suggestionsDB.writeToStorage();
                    campDataBase.writeToStorage();
                    registrationDataBase.writeToStorage();
                    enquiriesDB.writeToStorage();
                    dataList.writeStaffToStorage();
                    dataList.writeStudentToStorage();
                    System.out.println("All data information saved! Exiting...");
                    break;
                }

                while (true) {
                    
                    // use s to know whether it is staff or student: 
                    if (dataList.containsStudent(username)) {
                        Student userObject=(Student)dataList.getStudent(username);
                        String indexCommand = commandParser.handleStudentCommand(dataList,username,userObject);
                        if (indexCommand.equals("14")) {
                       
                            break;
                        }
                    } else if (dataList.containsStaff(username)) {
                        Staff userObject=(Staff)dataList.getStaff(username);
                        String s1 = commandParser.handleStaffCommand(dataList,username,userObject);
                        if (s1.equals("15")) {

                            break;
                        }
                    } 

                }

            } catch (Exception e) {
                System.out.println(Message.FAILED + e.getMessage());
            }

        }
    }
}
