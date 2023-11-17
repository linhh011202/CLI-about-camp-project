package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/** 
 * Represents a class that generates a camp report that contains all camp details, as well as camp participants and their roles,
 * for all camps that a staff is in charge of.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StaffStudentReportGenerator implements IGenerateStudentReport {
    /**
     * The camp database that this StaffStudentReportGenerator manages.
     */
    private CampDataBase campDataBase;

    /**
     * The interface from registration database that this StaffStudentReportGenerator uses to get the list of 
     * students and their roles in his camps.
     */
    private IGetStudentNamesRolesRegistered registeredStudentNamesRolesGetter;


    /**
     * Creates a new StaffStudentReportGenerator with its associated camp database and interface it requires to generate the
     * student report for a staff.
     * @param campDataBase The camp database that this StaffStudentReportGenerator manages.
     * @param registeredStudentNamesRolesGetter The interface from registration database that this StaffStudentReportGenerator uses to get the list of 
     * students and their roles in his camps.
     */
    public StaffStudentReportGenerator(CampDataBase campDataBase,
            IGetStudentNamesRolesRegistered registeredStudentNamesRolesGetter) {
        this.campDataBase = campDataBase;
        this.registeredStudentNamesRolesGetter = registeredStudentNamesRolesGetter;
    }

    /**
     * Creates a file in the given file name and returns a File object if successful.
     * Function fails if a file with the specified file name already exists.
     * @param fileName The desired filename to generate the report to.
     * @return The successfully created file, or null on failure.
     */
    private File createFile(String fileName) {
        try {
            // Try to create a \Reports output directory if it doesnt exist.
            Path reportsDirectory = Paths.get("project\\src\\Camp Reports");
            if (!Files.exists(reportsDirectory)) {
                try {
                    Files.createDirectories(reportsDirectory);
                    System.out.println("Reports directory created.");
                } catch (IOException e) {
                    System.out.println("Failed to create Reports directory.");
                    e.printStackTrace();
                    return null;
                }
            }

            // Create file in that directory to write to.If name already exists, fail and
            // return.
            File myObj = new File(reportsDirectory.toFile(), fileName + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                return myObj;
            } else {
                System.out.println("Failed to generate report in file! That file name already exists!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public void generateStudentReport(User user, ISortCamps iSortCamps, IFilterCamps iFilterCamps,
            String filterString) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.printf("You are about to generate a student report! Enter name of output file: ");
            String fileName = sc.nextLine();
            File outputFile = createFile(fileName);
            if (outputFile == null) {
                sc.close();
                return;
            }
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("STUDENT REPORT FOR STAFF: %s\n**************************************************\n\n",
                    user.getName());

            ArrayList<Camp> allCamps = campDataBase.getAllCamps();

            // Sort and set filter bits first.
            iSortCamps.sortCamps();
            iFilterCamps.filterCamps(filterString);

            // For each camp in the database, check if
            // 1.It belongs to staff
            // 2.It is NOT Filtered out

            // Then proceed to output camp details, and all the students in camp and their
            // roles.
            for (int i = 0; i < allCamps.size(); ++i) {
                if (allCamps.get(i).getStaffInCharge().equals(user.getName())
                        && !(allCamps.get(i).getIsFilteredOut())) {
                    allCamps.get(i).printCampToFile(printWriter);

                    // Get student list and roles from registrationDB interface, and output as well.
                    ArrayList<ArrayList<String>> studentNamesRoles = registeredStudentNamesRolesGetter
                            .getRegisteredStudentNamesRoles(allCamps.get(i).getCampName());
                    printWriter.print("List of students and their roles for the above camp:\n");
                    if (studentNamesRoles.size() == 0) {
                        printWriter.println("No students registered for this camp!");
                    } else {
                        for (int j = 0; j < studentNamesRoles.size(); ++j) {
                            printWriter.printf("|| Student Name: %s | Role: %s||\n", studentNamesRoles.get(j).get(0),
                                    studentNamesRoles.get(j).get(1));
                        }
                    }
                    printWriter.println("----------------------------------------\n\n");
                }
            }

            printWriter.println("-------------END OF REPORT--------------");
            System.out.printf("Successfully generated student report in %s.txt!\n\n", fileName);

            // Close resources, close scanner in main file instead so we can continue using
            // System.in as long as program persists.
            printWriter.close();
        } catch (IOException e) {
            System.out.printf("An error occured while generating report!\n");
            return;
        }

    }
}
