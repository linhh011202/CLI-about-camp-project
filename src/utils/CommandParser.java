package utils;

import java.util.Scanner;

import javax.xml.crypto.Data;

import user.DataList;
import utils.Login;

public class CommandParser {
    // public void printStatus(String s){
    // System.out.println(s);
    // }
    Scanner scanner = new Scanner(System.in);

    public String handleStudentCommand(DataList datalist, String username) {
        Message.printAllStudentCommands();// in mot dong comment 1 2 3 4 5..
        Message.printDivider();

        Scanner scanner = new Scanner(System.in);

        // Implement handling of student commands
        // CommandParser handle= new CommandParser();
        // handle.handleStudentCommand();
        System.out.println("Type the index for command: ") ; 
        String studentCommand = scanner.nextLine().trim();
        Message.printDivider();
        switch (studentCommand) {
            case "0":
                // Handle edit password command
                // handleStudentCommand1();
                // testing: System.out.println("Your command is :" +studentCommand);
                //s, datalist; 
                //datalist, username
                
                handleStudentCommandChangePassword(datalist, username); 
                break; 
                
                
            case "1":
                // Register for a camp

                
                break;
            case "2":
                // Deregister from registered camp
                break;
            case "3":
                //Register as a Camp Committee

                break;
            case "4":
                // View registered camps

                break;
            case "5":
                // Generate Report

                break;
            case "6":
               //Log Out
               System.out.println("You log out the programm");

                break;
            default:
                System.out.println("Invalid command");
                break;

        }
        return studentCommand;

    }
// write again the code to change the password
    public void handleStudentCommandChangePassword(DataList datalist, String username) {
        
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a new password: ");
            String newPassword = scanner.nextLine().trim();
            datalist.setNewStudentPasswordWithInput(username, newPassword);
            System.out.println("Your password has been changed to: " + newPassword);

        
           

    
        }


    

    public void handleStudentCommandLogout() {
        // handle handle
        // ==> quay lai log out

    }

    public void handleStudentCommandHandleRegister() {
        // Handle register for a camp command

    }

    public void handleStudentCommand4() {
        // Handle deregister from registered camp command

    }

    public void handleStudentCommand5() {
        // Handle register as a Camp Committee command

    }

    public void handleStudentCommand6() {
        //// Handle view registered camps command
    }
     public void handleStudentCommand7() {
        //// Handle view registered camps command
    }
////////////////////////////////////////////////////////////////////////////////staff/////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
public String handleStaffCommand(DataList datalist, String username) {
        Message.printAllStaffCommands();// in mot dong comment 1 2 3 4 5..
        Message.printDivider();

        Scanner scanner1 = new Scanner(System.in);

        // Implement handling of student commands
        // CommandParser handle= new CommandParser();
        // handle.handleStudentCommand();
        System.out.println("Type the index for command: "); 

        String staffCommand = scanner1.nextLine().trim();
        Message.printDivider();
        switch (staffCommand) {
            case "0":
                //Change password 
                handleStaffCommandChangePassword(datalist, username); 
                break;

            case "1":
                // Create camp

                
                break;
            case "2":
                // Delete camp

                break;
            case "3":
                //Edit camp 


                break;
            case "4":
                // Generate Student Report

                break;
            case "5":
                // Generate Performance Report

                break;
            case "6":
               //Log Out
            System.out.println("You  are logging out the programm");

                break;
            default:
                System.out.println("Invalid command");
                break;

        }
        return staffCommand; 

    }

    public void handleStaffCommandChangePassword(DataList datalist, String username) {

        // change password
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new password: ");
        String newPassword = scanner.nextLine().trim();
        datalist.setNewStaffPasswordWithInput(username, newPassword);
        System.out.println("Your password has been changed to: " + newPassword);
        Message.printDivider();


    }

    public void handleStaffCommandCreateCamp() {
        // handle handle
        // ==> quay lai log out

    }

    public void handleStaffCommandDeleteCamp() {
        // Handle register for a camp command

    }

    public void handleStaffCommandEditCamp() {
        // Handle deregister from registered camp command

    }

    public void handleStaffCommand4() {
        // Handle register as a Camp Committee command

    }

    public void handleStaffCommand5() {
        //// Handle view registered camps command
    }
     public void handleStaffCommand6() {
        //// Handle view registered camps command
    }



}

// parse command index(1,2,3....6)
// similar to startlogin

// handle command index
// same as Handlelogin which ask user the specific parameter of the user

// handleCommand1
// param a b c
// handleCommand2
// param x y
// handleCommand3
// param x y z
