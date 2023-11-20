package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * Represents a class that helps to generate a Camp Report for all camps that a student is a
 * Camp Committee member of.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CampComStudentReportGenerator implements IGenerateStudentReport {
    /**
     * The Camp Database that this CampComStudentReportGenerator manages.
     */
    private CampDataBase campDataBase;

    /**
     * The interface that this CampComStudentReportGenerator uses to retrieve the list of camps he is a committee member of.
     */
    private IGetCampsIsCommittee listOfCampsIsCommiteeOfGetter;

    
    /**
     * The interface that this CampComStudentReportGenerator uses to retrieve the roles and names of students
     * for the camps he is a committee member of, in order to print them in the report.
     */
    private IGetStudentNamesRolesRegistered registeredStudentNamesRolesGetter;

    /**
     * Creates a new CampComStudentReportGenerator with the given Camp Database and interfaces required.
     * @param campDataBase The Camp Database that this CampComStudentReportGenerator manages.
     * @param registeredStudentNamesRolesGetter The interface that this CampComStudentReportGenerator uses to retrieve the roles and names of students from the registration database for the camps he is a committee member of, in order to print them in the report.
     * @param listOfCampsIsCommiteeOfGetter The interface that this CampComStudentReportGenerator uses to retrieve the list of camps he is a committee member of from the registration database.
     */
    public CampComStudentReportGenerator(CampDataBase campDataBase,
            IGetStudentNamesRolesRegistered registeredStudentNamesRolesGetter,
            IGetCampsIsCommittee listOfCampsIsCommiteeOfGetter) {
        this.campDataBase = campDataBase;
        this.registeredStudentNamesRolesGetter = registeredStudentNamesRolesGetter;
        this.listOfCampsIsCommiteeOfGetter = listOfCampsIsCommiteeOfGetter;
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
            Path reportsDirectory = Paths.get("project\\src\\Reports\\Camp Reports");
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
            // Confirm that not a staff is using this function, though that should not be
            // able to happen.
            if (!(user instanceof Student)) {
                System.out.printf("Failed to generate report for camps you are a camp committee of!"
                        + " Only a student can call this function.\n");
                return;
            }
            Student student = (Student) user;

            //Only allow generation of report if student is camp committee of a camp.
            if(!student.getIsCommittee())
            {
                System.out.printf("Failed to generate report! You are not a camp committee member of any camps!\n");
                return;
            }

            // Create directory and file to write report in.
            Scanner sc = new Scanner(System.in);
            System.out.printf(
                    "You are about to generate a student report for Camps you are Camp Committee of! Enter name of output file: ");
            String fileName = sc.nextLine();
            File outputFile = createFile(fileName);
            if (outputFile == null) {
                sc.close();
                return;
            }
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Write report
            printWriter.printf(
                    "STUDENT REPORT FOR CAMP COMMITEE MEMBER: %s\n**************************************************\n\n",
                    user.getName());
            ArrayList<Camp> allCamps = campDataBase.getAllCamps();

            // Sort and set filter bits first.
            iSortCamps.sortCamps();
            iFilterCamps.filterCamps(filterString);

            ArrayList<String> campsIsCommittee = listOfCampsIsCommiteeOfGetter.getCampsIsCommittee(student);

            // For each camp in the database, check if student is a committee of that camp.
            // If yes, print details of camp
            // and student participant details

            boolean noCamps = true;
            for (int i = 0; i < allCamps.size(); ++i) {
                for (int j = 0; j < campsIsCommittee.size(); ++j) {
                    if (!allCamps.get(i).getIsFilteredOut()
                            && allCamps.get(i).getCampName().equals(campsIsCommittee.get(j))) {
                        noCamps = false;
                        allCamps.get(i).printCampToFile(printWriter);
                        ArrayList<ArrayList<String>> studentNamesRoles = registeredStudentNamesRolesGetter
                                .getRegisteredStudentNamesRoles(allCamps.get(i).getCampName());

                        // Output the registered students
                        if (studentNamesRoles.size() == 0) {
                            printWriter.println("No students registered for this camp!");
                        } else {
                            for (int k = 0; k < studentNamesRoles.size(); ++k) {
                                printWriter.printf("|| Student Name: %s | Role: %s||\n",
                                        studentNamesRoles.get(k).get(0), studentNamesRoles.get(k).get(1));
                            }
                        }
                        printWriter.println("----------------------------------------\n\n");
                    }
                }
            }
            if (noCamps) {
                printWriter.println("-----NO CAMPS TO PRINT-----");
            }
            printWriter.println("-------------END OF REPORT--------------");
            System.out.printf("Successfully generated student report in %s.txt!\n\n", fileName);

            // Close resources, close scanner in main file instead so we can continue using
            // System.in as long as program persists.
            printWriter.close();
        } catch (IOException exception) {
            System.out.printf("An error occured while generating report!\n");
            return;
        }

    }

}
