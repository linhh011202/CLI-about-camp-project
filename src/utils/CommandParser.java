package utils;

import java.util.Scanner;
import user.DataList;
import utils.Login;

public class CommandParser {
    // public void printStatus(String s){
    // System.out.println(s);
    // }

    public String handleStudentCommand() {
        Message.printAllStudentCommands();// in mot dong comment 1 2 3 4 5..
        Message.printDivider();

        Scanner scanner = new Scanner(System.in);

        // Implement handling of student commands
        // CommandParser handle= new CommandParser();
        // handle.handleStudentCommand();
        System.out.println("Your  Student command: ");

        String studentCommand = scanner.nextLine().trim();
        Message.printDivider();
        switch (studentCommand) {
            case "1":
                // Handle edit password command
                // handleStudentCommand1();
                // testing: System.out.println("Your command is :" +studentCommand);

                break;
            case "2":
                // Handle log out command
                // handleStudentCommand2();
                System.out.println("You log out the programm");
                break;
            case "3":
                // Handle register for a camp command
                //System.out.println(studentCommand);
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
        return studentCommand;

    }

    public void handleStudentCommandChangePassword() {

        // change password

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
