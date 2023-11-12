package merge;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class StaffStudentReportGenerator implements IGenerateStudentReport
{
    private CampDataBase campDataBase;
    private IGetStudentNamesRolesRegistered registeredStudentNamesRolesGetter;
    public StaffStudentReportGenerator(CampDataBase campDataBase,IGetStudentNamesRolesRegistered registeredStudentNamesRolesGetter)
    {
        this.campDataBase=campDataBase;
        this.registeredStudentNamesRolesGetter=registeredStudentNamesRolesGetter;
    }

    private File createFile(String fileName) {
        try 
        {
          //Try to create a \Reports output directory if it doesnt exist.
            Path reportsDirectory = Paths.get("Student Reports");
            if (!Files.exists(reportsDirectory)) 
            {
                try 
                {
                    Files.createDirectories(reportsDirectory);
                    System.out.println("Reports directory created.");
                } 
                catch (IOException e) 
                {
                    System.out.println("Failed to create Reports directory.");
                    e.printStackTrace();
                    return null;
                }
            }

            //Create file in that directory to write to.If name already exists, fail and return.
            File myObj = new File(reportsDirectory.toFile(), fileName + ".txt");
            if (myObj.createNewFile()) 
            {
                System.out.println("File created: " + myObj.getName());
                return myObj;
            } 
            else 
            {
                System.out.println("Failed to generate report in file! That file name already exists!");
            }
        } 
        catch (IOException e) 
        {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return null;
      }

    public void generateStudentReport(User user,ISortCamps iSortCamps,IFilterCamps iFilterCamps,String filterString)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.printf("You are about to generate a student report! Enter name of output file: ");
            String fileName=sc.nextLine();
            File outputFile=createFile(fileName);
            if (outputFile == null) 
            {
                sc.close();
                return;
            }
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("STUDENT REPORT FOR STAFF: %s\n**************************************************\n\n",user.getName());

            ArrayList<Camp> allCamps=campDataBase.getAllCamps();

            //Sort and set filter bits first.
            iSortCamps.sortCamps();
            iFilterCamps.filterCamps(filterString);

            //For each camp in the database, check if 
            //1.It belongs to staff
            //2.It is NOT Filtered out
            
            //Then proceed to output camp details, and all the students in camp and their roles.
            for(int i=0;i<allCamps.size();++i)
            {
                if(allCamps.get(i).getStaffInCharge().equals(user.getName()) && !(allCamps.get(i).getIsFilteredOut()))
                {
                    allCamps.get(i).printCampToFile(printWriter);
                    
                    //Get student list and roles from registrationDB interface, and output as well.
                    ArrayList<ArrayList<String>> studentNamesRoles=registeredStudentNamesRolesGetter.getRegisteredStudentNamesRoles(allCamps.get(i).getCampName());
                    printWriter.print("List of students and their roles for the above camp:\n");
                    if(studentNamesRoles.size()==0)
                    {
                        printWriter.println("No students registered for this camp!");
                    }
                    else
                    {
                        for(int j=0;j<studentNamesRoles.size();++j)
                        {
                            printWriter.printf("|| Student Name: %s | Role: %s||\n",studentNamesRoles.get(j).get(0),studentNamesRoles.get(j).get(1));
                        }
                    }
                    printWriter.println("----------------------------------------\n\n");
                }
            }

            printWriter.println("-------------END OF REPORT--------------");
            System.out.printf("Successfully generated student report in %s.txt!\n\n",fileName);
            
            //Close resources, close scanner in main file instead so we can continue using System.in as long as program persists.
            printWriter.close();
        }
        catch (IOException e)
        {
            System.out.printf("An error occured while generating report!\n");
            return;
        }
        
    }
}
