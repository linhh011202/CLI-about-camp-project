import user.User;

import java.io.File;
import java.util.Scanner;

import FileLoader;
import user.DataList;// Import DataList definition

public class Driver {


    // Define the instance of the DataList as this will be used by the Main program


    public static void main(String[] args) {  // THIS IS THE ENTRY POINT OF THE PROGRAM
        System.out.println("Start program"); // This is a print statement
        DataList dataList = new DataList();

        // FileLoader.readFile(FileLoader.STUDENT_PATH); This is just a dummy function to check 
        // We want to load the data in the file into the list, so it might go something like this
        FileLoader.loadFile(FileLoader.STUDENT_PATH, "student", dataList.studentList);// We want to load the student file into the student list
        FileLoader.loadFile(FileLoader.STAFF_PATH, "staff", dataList.staffList);// We want to load the staff file into the staff list
        
        // It says that we cannot pass ArrayList<Student> into ArrayList<User>, but polymorphishm says it should right?
        // Let's run to find out
        // Ok so it doesn't work... SO where does Polymorphism work?
        System.out.println("Student List Size: " + dataList.studentList.size());
        System.out.println("Staff List Size: "+ dataList.staffList.size());

        System.out.println("First Student Name" + dataList.studentList.get(0).name); 
        // Get the first element of the student list, and get the name of that student
        // Oh no.. it get ugly again... Might as well just edit the student list....

        
        System.out.println("Finish Loading Files"); // This is a print statement


        // //while loop to ask user if they want to exit the program, write exit to exit
        // Scanner scanner = new Scanner(System.in);
        // String input = "";
        // while (!input.equals("exit")) {
        //     System.out.println("Enter a command: ");
        //     input = scanner.nextLine();
        //     System.out.println("You entered: " + input);
        // }
    


    }
}


