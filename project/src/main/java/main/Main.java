package main;

import main.utils.FileLoader;

import java.io.File;
import java.util.Scanner;

import javax.xml.crypto.Data;

import main.utils.CommandParser;
import main.utils.*; 

import main.user.DataList; // Import DataList definition
import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public class Main {

    // Define the instance of the DataList as this will be used by the Main program

    public static void main(String[] args) { // THIS IS THE ENTRY POINT OF THE PROGRAM
        // System.out.println("Start program"); // This is a print statement

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

        // Assuming you have a DataList class
        // DataList dataList = new DataList();
        // my aim is to write something that can know that they are user or staff in the
        // main function, instead of Login.java
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

                // commandParser.printStatus("command parser" + s);
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
                // }

                // }
            } catch (Exception e) {
                System.out.println(Message.FAILED + e.getMessage());
            }

        }

        // Close the scanner
        // scanner.close();

        // FileLoader.readFile(FileLoader.STUDENT_PATH); This is just a dummy function
        // to check
        // We want to load the data in the file into the list, so it might go something
        // like this
        // System.out.println("Finish Loading Files"); // This is a print statement

        // String enteredUsername = "";

        // while(true){
        // System.out.print("Enter: ");
        // enteredUsername = scanner.nextLine().trim();
        // if(enteredUsername.equals("exit")){
        // break;
        // }
        // System.out.println("You entered: " + enteredUsername);

        // // add, edit, delete
        // // print "Add command"
        // switch(enteredUsername){
        // case "add":
        // System.out.println("Add command");
        // break;
        // case "edit":
        // System.out.println("Edit command");
        // break;
        // case "delete":
        // System.out.println("Delete command");
        // break;
        // default:
        // System.out.println("Invalid command");
        // break;
        // }

        // }

        // while (true) {
        // try{
        // Message.printDivider();// to print the divider
        // ===================================================
        // System.out.println(Message.HELLO); // to print : Welcome to the application
        // System.out.println("Your command: ");
        // String enteredCommand = scanner.nextLine().trim();
        // if(enteredCommand.equals("exit")){
        // break;
        // }
        // else if(enteredCommand.equals("login")){
        // Message.printDivider();// to print the divider
        // ===================================================
        // Message.printUsernamePasswordPrompt(); // to print : Please enter your name
        // and password;
        // Message.printUsernameMessage();// print to user: "Username: ...?"
        // String enteredUsername = scanner.nextLine().trim();
        // if(dataList.containsStudent(enteredUsername) ){
        // Message.printPassWordMessage();// print to user: "Password: ...?"
        // String enteredPassword = scanner.nextLine().trim();
        // if(!enteredPassword.equals(dataList.getStudentPassword(enteredUsername)) ){
        // throw new Exception("Incorrect password");
        // }
        // System.out.println(Message.WELCOME + dataList.getStudentName(enteredUsername)
        // + "!");
        // }
        // else if(dataList.containsStaff(enteredUsername)) {
        // Message.printPassWordMessage();// print to user: "Password: ...?"
        // String enteredPassword = scanner.nextLine().trim();
        // if(!enteredPassword.equals(dataList.getStaffPassword(enteredUsername)) ){
        // throw new Exception("Incorrect password");
        // }
        // System.out.println(Message.WELCOME + dataList.getStaffName(enteredUsername) +
        // "!");

        // }
        // else{
        // throw new Exception("Username not found");
        // }

        // }
        // else{
        // throw new Exception("Invalid command");
        // }
        // }catch(Exception e){
        // System.out.println(Message.FAILED+ e.getMessage());
        // }
        // }

    }
}
