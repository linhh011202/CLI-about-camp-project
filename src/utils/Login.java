package utils;

import user.User;
import utils.FileLoader;

import java.io.File;
import java.util.Scanner;
import utils.ExcetionHandling;

import user.DataList; // Import DataList definition
import utils.Message;
import user.Student;
import utils.CommandParser;

public class Login {
    private Scanner scanner;

    public Login(Scanner scanner) {
        this.scanner = scanner;
    }
    // can write here as static , de do phai tao ra instance(?):
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

    public String handleLogin(DataList dataList) throws Exception {
        Message.printDivider();
        Message.printUsernamePasswordPrompt();
        Message.printUsernameMessage();// print asking user: "username: "
        String enteredUsername = scanner.nextLine().trim();

        if (dataList.containsStudent(enteredUsername)) {
            Message.printPassWordMessage();// print asking for password
            String enteredPassword = scanner.nextLine().trim();
            if (!enteredPassword.equals(dataList.getStudentPassword(enteredUsername))) {
                throw new Exception("Incorrect password");
            }
            System.out.println(Message.WELCOME + dataList.getStudentName(enteredUsername) + "!");
            Message.printDivider();
            System.out.println("You are a student!");
            Message.printDivider();
            
 
            return(enteredUsername); 
            // do something here
         
            // Print student commands:

            //i have to list all students'commands here:

            // System.out.println("Student Commands:"
            // + "1. Edit password"
            // +"2. Log out"
            // + "3. Register for a camp"
            // +"4. Deregister from registered camp"
            // +"5. Register as a Camp Committee"
            // +"6. View registered camps");

           

        } else if (dataList.containsStaff(enteredUsername)) {
            Message.printPassWordMessage();
            String enteredPassword = scanner.nextLine().trim();
            if (!enteredPassword.equals(dataList.getStaffPassword(enteredUsername))) {
                throw new Exception("Incorrect password");
            }
            System.out.println(Message.WELCOME + dataList.getStaffName(enteredUsername) + "!");
            Message.printDivider();
            System.out.println("You are a staff!");
            Message.printDivider();
            return(enteredUsername);             // Print student commands:

            // do something with staff which i have to implement later
            //
        } else {
            throw new Exception("Username not found");
        }
    }
    
}