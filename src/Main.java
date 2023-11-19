import user.User;
import utils.FileLoader;

import java.io.File;
import java.util.Scanner;

import utils.CommandParser;
import utils.ExcetionHandling;

import user.DataList; // Import DataList definition
import utils.Message;
import utils.Login; // Import Login definition

public class Main {

    // Define the instance of the DataList as this will be used by the Main program

    public static void main(String[] args) { // THIS IS THE ENTRY POINT OF THEll PROGRAM
        // System.out.println("Start program"); // This is a print statement
        DataList dataList = new DataList(); // Variable
        FileLoader.loadFile(FileLoader.STUDENT_PATH, "student", dataList.studentList);// We want to load the student
                                                                                      // file into the student list
        FileLoader.loadFile(FileLoader.STAFF_PATH, "staff", dataList.staffList);// We want to load the staff file into
                                                                                // the staff list

        Scanner scanner = new Scanner(System.in);
        Login login = new Login(scanner);
        CommandParser commandParser = new CommandParser();

        // Assuming you have a DataList class
        // DataList dataList = new DataList();
        // my aim is to write something that can know that they are user or staff in the
        // main function, instead of Login.java
        while (true) {
            try {
                String s = login.startLogin(dataList);
                // exit
                if (s.equals("exit")) {
                    break;
                }

                // commandParser.printStatus("command parser" + s);
                while(true){
                    CommandParser commandParser1= new CommandParser(); 
                    String s1 = commandParser1.handleStudentCommand();
                    
                    if(s1.equals("2")){
                        break; 
                    }
                }   
            // }
        
    

            //} 
            } 
            catch (Exception e) {
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
