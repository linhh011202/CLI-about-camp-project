package utils;
import java.util.Scanner;
import utils.Message; 
import utils.FileLoader; // We need to import the FileLoader class from the utils package


import user.DataList;

public class Checking {
     public static void check() {
            
            DataList dataList = new DataList();
            FileLoader.loadFile(FileLoader.STUDENT_PATH, "student", dataList.studentList);// We want to load the student file into the student list
            FileLoader.loadFile(FileLoader.STAFF_PATH, "staff", dataList.staffList);
            Scanner scanner= new Scanner(System.in);
            while (true) {
                Message.printUsernamePasswordPrompt();
                Message.printUsernameMessage();
                String enteredUsername = scanner.nextLine();
                Message.printPassWordMessage();
                String enteredPassword = scanner.nextLine();

                // Split the entered username based on "@" character
                String[] parts = enteredUsername.split("@");

                try {
                    // Check if the username is in the student list
                    if (!dataList.containsStudent(parts[0])) {
                        throw new Exception("Username not found");
                    }

                    // Get the student's password based on the entered username
                    String storedPassword = dataList.getStudentPassword(parts[0]);

                    // Check if the entered password matches the stored password
                    if (!enteredPassword.equals(storedPassword)) {
                        throw new Exception("Incorrect password");
                    }

                    // If username and password are correct, print student name
                    String studentName = dataList.getStudentName(parts[0]);
                    System.out.println("Welcome, " + studentName + "!");
                    break; // Exit the loop if authentication is successful

                } catch (Exception e) {
                    System.out.println("Authentication failed: " + e.getMessage());
                }
            }

            scanner.close();
        }
    }