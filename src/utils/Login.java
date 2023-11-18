package utils;

import user.User;
import utils.FileLoader;

import java.io.File;
import java.util.Scanner;
import utils.ExcetionHandling;

import user.DataList; // Import DataList definition
import utils.Message;
import user.Student;

public class Login {
    private Scanner scanner;

    public Login(Scanner scanner) {
        this.scanner = scanner;
    }

    public String startLogin(DataList x) throws Exception{
            
                Message.printDivider();
                System.out.println(Message.HELLO);
                System.out.println("Your command: ");
                String enteredCommand = scanner.nextLine().trim();

                if (enteredCommand.equals("exit")) {
                    return "exit";
                } else if (enteredCommand.equals("login")) {
                    return handleLogin(x);
                
                } else {
                    throw new Exception("Invalid command");
                }

            
            
    }

    private String handleLogin(DataList dataList) throws Exception {
        Message.printDivider();
        Message.printUsernamePasswordPrompt();
        Message.printUsernameMessage();
        String enteredUsername = scanner.nextLine().trim();

        if (dataList.containsStudent(enteredUsername)) {
            Message.printPassWordMessage();
            String enteredPassword = scanner.nextLine().trim();
            if (!enteredPassword.equals(dataList.getStudentPassword(enteredUsername))) {
                throw new Exception("Incorrect password");
            }
            System.out.println(Message.WELCOME + dataList.getStudentName(enteredUsername) + "!");
            System.out.println("You are a student!");
            return(dataList.getStudentName(enteredUsername));             // Print student commands:

            //i have to list all students'commands here:

            // System.out.println("Student Commands:"
            // + "1. Edit password"
            // +"2. Log out"
            // + "3. Register for a camp"
            // +"4. Deregister from registered camp"
            // +"5. Register as a Camp Committee"
            // +"6. View registered camps");

           
            // System.out.println("Your command: ");
            
            // String studentCommand = scanner.nextLine().trim();
            // handleStudentCommand(studentCommand);

            // add students'commands:
            // 1/Edit password
            // 2/Log out
            // 3/Register for a camp
            // 4/Deregister from registered camp
            // 5/Register as a Camp Committee
            // 6/View registered camps

        } else if (dataList.containsStaff(enteredUsername)) {
            Message.printPassWordMessage();
            String enteredPassword = scanner.nextLine().trim();
            if (!enteredPassword.equals(dataList.getStaffPassword(enteredUsername))) {
                throw new Exception("Incorrect password");
            }
            System.out.println(Message.WELCOME + dataList.getStaffName(enteredUsername) + "!");
            System.out.println("You are a staff!");
            return(dataList.getStaffName(enteredUsername));             // Print student commands:

            // do something with staff which i have to implement later
            //
        } else {
            throw new Exception("Username not found");
        }
    }
    private void handleStudentCommand(String studentCommand) {
        // Implement handling of student commands
        switch (studentCommand) {
            case "1":
                // Handle edit password command
                break;
            case "2":
                // Handle log out command
                break;
            case "3":
                // Handle register for a camp command
                break;
            case "4":
                // Handle deregister from registered camp command
                break;
            case "5":
                // Handle register as a Camp Committee command
                break;
            case "6":
                // Handle view registered camps command
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }
}