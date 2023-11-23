package main.utils;

import java.io.File;
import java.util.Scanner;

import main.user.DataList; // Import DataList definition
import main.utils.*;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;
import main.user.DataList;

/** 
 * A login class that handles all logging in functionality in the main app.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-24
*/
public class Login {
    /**
     * This Login object's scanner.
     */
    private Scanner scanner;

    /**
     * Creates a new Login object with a scanner to read in user input.
     * @param scanner The scanner to read in user input.
     */
    public Login(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Gives the user options to choose when logging in , either to log in or exit the application. It throws an exception if the user sends an invalid input. This exception is handled by the main app.
     * @param x The datalist that contains all the user objects, so we can verify the usernames and passwords.
     * @return The username of the user that has successfully logged in.
     * @throws Exception Throws an exception if an invalid command is input, handled by the main app.
     */
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

    /**
     * Handles the verification process of the user if he decides to log in.
     * @param dataList The datalist that contains all the user objects, so we can verify the usernames and passwords.
     * @return The username of the user that has successfully logged in.
     * @throws Exception Throws an exception with a message containing information on the type of error, whether if the username does not exist, or the password is wrong.
     */
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