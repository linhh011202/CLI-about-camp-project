package main.utils;

import java.util.Scanner;
import javax.xml.crypto.Data;

import main.user.DataList;
import main.utils.Login;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.time.LocalDate;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public class CommandParser {
    // public void printStatus(String s){
    // System.out.println(s);
    // }

    /**
     * This CommandParser's Scanner used to take in user input.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * This CommandParser's associated suggestions database for the user to utilise and interact with the Suggestions.
     */
    private SuggestionsDB suggestionsDB;

    /**
     * This CommandParser's associated camp database for the user to utilise and interact with the Camp Database Interaces.
     */
    private CampDataBase campDataBase;

    /**
     * This CommandParser's associated registrations database for the user to utilise and interact with the Registration Database Interaces.
     */
    private RegistrationDataBase registrationDataBase;

    /**
     * This CommandParser's associated enquiries database for the user to utilise and interact with the Enquiries.
     */
    private EnquiriesDB enquiriesDB;

    /**
     * This CommandParser's associated User Database to obtain the current user object.
     */
    private DataList dataList;

    /**
     * Creates a CommandParser with the appropriate data bases required.
     * @param suggestionsDB This CommandParser's associated suggestions database for the user to utilise and interact with the Suggestions.
     * @param campDataBase This CommandParser's associated camp database for the user to utilise and interact with the Camp Database Interaces.
     * @param registrationDataBase This CommandParser's associated registrations database for the user to utilise and interact with the Registration Database Interaces.
     * @param enquiriesDB This CommandParser's associated enquiries database for the user to utilise and interact with the Enquiries.
     * @param dataList This CommandParser's associated User Database to obtain the current user object.
     */
    public CommandParser(SuggestionsDB suggestionsDB,CampDataBase campDataBase,RegistrationDataBase registrationDataBase,EnquiriesDB enquiriesDB,DataList dataList)
    {
        this.suggestionsDB=suggestionsDB;
        this.campDataBase=campDataBase;
        this.registrationDataBase=registrationDataBase;
        this.enquiriesDB=enquiriesDB;
        this.dataList=dataList;

    }

    public String handleStudentCommand(DataList datalist, String username,Student student) {
        Scanner scanner = new Scanner(System.in);

        //We must ensure the user changes password on first login.
        String studentCommand;
        if(student.getPassword().equals("password"))
        {
            System.out.printf("Your password is the default password! Please change it:\n");
            studentCommand="0";
        }
        
        // Implement handling of student commands
        // CommandParser handle= new CommandParser();
        // handle.handleStudentCommand();
        else
        {
            Message.printDivider();
            System.out.println("\nYou can customise your sorting categories, and filter out specific items within categories.\ne.g Only show camps with Filter Category Location, where filterString 'Pioneer'.");
            System.out.println("Set the sort, filter, and filterStrings and they will affect the camps filtered out, and their order, when viewing camps or generating reports.\n");
            Message.printAllStudentCommands();// in mot dong comment 1 2 3 4 5..
            Message.printDivider();
            System.out.println("Type the index for command: ") ; 
            studentCommand = scanner.nextLine().trim();
            Message.printDivider();

        }
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
                handleStudentCommandHandleRegister(student);
                break;
            case "2":
                // Deregister from registered camp
                handleStudentCommandDeregister(student);
                break;
            case "3":
                //Register as a Camp Committee
                if(student.getIsCommittee()) {
                    System.out.println("You are already a camp committee member of one camp! Unable to register as camp committee for another camp ");
                    break;
                }
                handleStudentCommandCampCommittee(student);
                break;
            case "4":
                // View all camps
                handleStudentCommandViewAllCamps(student);
                break;
            case "5":
                // View registered camps
                handleStudentCommandViewRegisteredCamps(student);
                break;
            case "6":
                // Camp committee commands
                // reply enquiry
                // send suggestions
                if(student.getIsCommittee()){
                    CampCommittee campCom=(CampCommittee)student;       // upcast into campcommittee
                    handleCommitteeCommand(campCom);
                }
                else
                {
                    System.out.println("You are not a committee member of any camp yet! Unable to access these commands. Returning to menu...\n");
                }
                break;
            case "7":
                // View own enquiries
                handleStudentViewOwnEnquiries(student);
                break;
            case "8":
                // Send enquiry
                handleStudentSendEnquiry(student);
                break;
            case "9":
                // Edit enquiry
                handleStudentEditEnquiry(student);
                break;
            case "10":
                // Delete enquiry
                handleStudentDeleteEnquiry(student);
                break;
            case "11":
                // Set filter category
                handleStudentSetFilterCategory(student, campDataBase);
                break;
            case "12":
                // Set filter string
                handleStudentSetFilterString(student);
                break;
            case "13":
                // Set sorting category
                handleStudentSetSortingCategory(student, campDataBase);
                break;
            case "14":
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

    public void handleStudentCommandHandleRegister(Student student) {
        // Handle register for a camp command
        student.viewAllCamps();
        System.out.printf("Enter camp to register: ");
        String campName = scanner.nextLine();
        student.registerCampStudent(campName);
    }

    public void handleStudentCommandDeregister(Student student) {
        // Handle deregister from registered camp command
        System.out.println("These are your registered camps");
        student.viewRegisteredCamps();
        System.out.printf("Enter camp to deregister: ");
        String campName = scanner.nextLine();
        student.deregisterCamp(campName);
    }

    public void handleStudentCommandCampCommittee(Student student) {
        // Handle register as a Camp Committee command
        System.out.println("These are the available camps: ");
        student.viewAllCamps();
        System.out.printf("Enter camp to register: ");
        String campName = scanner.nextLine();
        dataList.updateUser(student.getName(), student.registerCampCommittee(campName));
    }

    public void handleStudentCommandViewAllCamps(Student student)
    {
        System.out.println("All visible camps: ");
        student.viewAllCamps();
    }
    public void handleStudentCommandViewRegisteredCamps(Student student) {
        //// Handle view registered camps command
        System.out.println("Your registered camps: ");
        student.viewRegisteredCamps();
    }
     public void handleCommitteeCommand(CampCommittee campCommittee) {
        //Handles campCom commands
        Message.printCommitteeCommands();
        System.out.printf("Type index for command (enter any other value to return to menu)");
        String s2 = scanner.nextLine();
        switch(s2) {
            case "1":
            System.out.printf("Enter the suggestion for the camp you are a committee member of: ");
            String text = scanner.nextLine();
            suggestionsDB.sendSuggestion(campCommittee.getCampName(),text,campCommittee.getName());
            campCommittee.addPoints();
            System.out.printf("You earned a point for submitting a suggestion!\n\n");
            dataList.updateUser(campCommittee.getName(), campCommittee);
            break;

            case "2":
            suggestionsDB.viewOwnSuggestion(campCommittee.getName());
            break;

            case "3":
            suggestionsDB.viewOwnSuggestion(campCommittee.getName());
            System.out.printf("Enter which suggestion number you want to edit: ");
            int suggestionNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("Enter new suggestion text: ");
            String newText = scanner.nextLine();
            suggestionsDB.editSuggestion(suggestionNumber, newText, campCommittee.getName());
            break;

            case "4":
            suggestionsDB.viewOwnSuggestion(campCommittee.getName());
            System.out.printf("Enter which suggestion number you want to delete: ");
            suggestionNumber = scanner.nextInt();
            scanner.nextLine();
            suggestionsDB.deleteSuggestion(suggestionNumber, campCommittee.getName());
            break;

            case "5":
            enquiriesDB.viewByCamp(new ArrayList<String>(Arrays.asList(campCommittee.getCampName())));
            break;

            case "6":
            enquiriesDB.viewByCamp(new ArrayList<String>(Arrays.asList(campCommittee.getCampName())));
            System.out.printf("Enter which enquiry number you want to reply to: ");
            int enquiryNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("Enter your reply: ");
            text = scanner.nextLine();
            boolean ret=enquiriesDB.addReply(enquiryNumber, text,new ArrayList<String>(Arrays.asList(campCommittee.getCampName())));    
            if(ret)
            {
                campCommittee.addPoints();                          // update points
                System.out.printf("You earned a point for replying to an enquiry!\n");
                dataList.updateUser(campCommittee.getName(), campCommittee);
            }
            
            break;

            case "7":
            campCommittee.generateCampComReport();
            break;

            case "8":
            System.out.printf("Enter the name of the file you would like to generate the report in: ");
            String fileName=scanner.nextLine();
            enquiriesDB.enquiryReport(new ArrayList<String>(Arrays.asList(campCommittee.getCampName())),fileName);
            break;
        }
    }

    public void handleStudentViewOwnEnquiries(Student student) {
        enquiriesDB.viewOwnEnquiry(student.getName());
    }

    public void handleStudentSendEnquiry(Student student) {
        student.viewAllCamps();
        System.out.printf("Enter which camp you want to send an enquiry: ");
        String campName = scanner.nextLine();
        System.out.printf("Enter your enquiry: ");
        String text = scanner.nextLine();
        enquiriesDB.sendEnquiry(campName,text,student);
    }

    public void handleStudentEditEnquiry(Student student)
    {
        enquiriesDB.viewOwnEnquiry(student.getName());
        System.out.printf("Enter enquiry ID that you want to edit: ");
        int enquiryId = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Enter new name of camp you want this enquiry to be for: ");
        String newCamp=scanner.nextLine();
        System.out.printf("Enter new enquiry to replace old one: ");
        String text = scanner.nextLine();
        enquiriesDB.editEnquiry(enquiryId,text,newCamp,student);
    }

    public void handleStudentDeleteEnquiry(Student student)
    {
        enquiriesDB.viewOwnEnquiry(student.getName());
        System.out.printf("Enter enquiry ID that you want to delete: ");
        int enquiryId = scanner.nextInt();
        scanner.nextLine();
        enquiriesDB.deleteEnquiry(enquiryId,student.getName());
    }

    public void handleStudentSetFilterCategory(Student student,CampDataBase campDataBase)
    {

        Message.printFilterCategoryCommands();

        System.out.printf("Enter which filter category you would like to select: ");
        String input=scanner.nextLine();

        switch(input)
        {
            case "1":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByNothing());
            break;

            case "2":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
            break;

            case "3":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByStartDate());
            break;

            case "4":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByEndDate());
            break;

            case "5":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByRegClosingDate());
            break;

            case "6":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByVisibility());
            break;

            case "7":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
            break;

            case "8":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByTotalSlots());
            break;

            case "9":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeSlots());
            break;

            case "10":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
            break;

            case "11":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableAttendeeSlots());
            break;

            case "12":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableCampComSlots());
            break;

            case "13":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByStaffIC());
            break;

            case "14":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByOpenTo());
            break;

            case "15":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeName());
            break;

            case "16":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCommitteeName());
            break;

            case "17":
            student.setCampFilter(campDataBase.getFilterManager().getFilterCampByDescription());
            break;

            default:
            System.out.println("Invalid filter option! Returning to menu...\n");
            return;
        }
        System.out.println("Filter set successfully! Camps will be filtered by this category using your filter string when viewing camps or generating reports.");
        
    }

    public void handleStudentSetFilterString(Student student)
    {
        System.out.println("Enter what you would like to find based on your filter category.");
        System.out.println("Example:\nIf filtering by Visibility status, input True or False.");
        System.out.println("If filtering by Location, input the name of the location.");
        System.out.printf("Input: ");
        String input=scanner.nextLine();
        student.setFilterString(input);
        System.out.println("Filter string set! Camps will be filtered with this string using your corresponding filter category when viewing camps or generating reports.");

    }

    public void handleStudentSetSortingCategory(Student student,CampDataBase campDataBase)
    {

        Message.printSortingCategoryCommands();

        System.out.printf("Enter which sorting category you would like to select: ");
        String input=scanner.nextLine();

        switch(input)
        {
            case "1":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByCampName());
            break;

            case "2":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByStartDate());
            break;

            case "3":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByEndDate());
            break;

            case "4":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByRegDate());
            break;

            case "5":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByVisibility());
            break;

            case "6":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByLocation());
            break;

            case "7":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByTotalSlots());
            break;

            case "8":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByAttendeeSlots());
            break;

            case "9":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByCampComSlots());
            break;

            case "10":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByAvailableAttendeeSlots());
            break;

            case "11":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByAvailableCampCommiteeSlots());
            break;

            case "12":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByDescription());
            break;

            case "13":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByStaffIC());
            break;

            case "14":
            student.setCampSorter(campDataBase.getSortManager().getSortCampByOpenTo());
            break;
            
            default:
            System.out.println("Invalid sorting option! Returning to menu...\n");
            return;
        }
        System.out.println("Sorting preference set successfully! Camps will now be sorted in this order when viewing or generating reports.");
        
    }



////////////////////////////////////////////////////////////////////////////////staff/////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////




public String handleStaffCommand(DataList datalist, String username,Staff staff) {

        Scanner scanner1 = new Scanner(System.in);
        String staffCommand;
        if(staff.getPassword().equals("password"))
        {
            System.out.printf("Your password is the default password! Please change it:\n");
            staffCommand="0";
        }
        
        // Implement handling of student commands
        // CommandParser handle= new CommandParser();
        // handle.handleStudentCommand();
        else
        {
            Message.printDivider();
            System.out.println("\nYou can customise your sorting categories, and filter out specific items within categories.\ne.g Only show camps with Filter Category Location, where filterString 'Pioneer'.");
            System.out.println("Set the sort, filter, and filterStrings and they will affect the camps filtered out, and their order, when viewing camps or generating reports.\n");
            Message.printAllStaffCommands();// in mot dong comment 1 2 3 4 5..
            Message.printDivider();
            System.out.println("Type the index for command: ") ; 
            staffCommand = scanner.nextLine().trim();
            Message.printDivider();
        }
        Message.printDivider();
        switch (staffCommand) {
            case "0":
                //Change password 
                handleStaffCommandChangePassword(datalist, username); 
                break;

            case "1":
                // View camps
                handleStaffViewCamps(staff);
                break;

            case "2":
                // Create camp
                handleStaffCommandCreateCamp(staff);

                break;
            case "3":
                // Delete camp
                handleStaffCommandDeleteCamp(staff);

                break;
            case "4":
                //Edit camp 
                handleStaffCommandEditCamp(staff);

                break;
            case "5":
                // Generate Student Report
                handleStaffGenerateStudentReport(staff);
                break;

            case "6":
                // Generate Performance Report
                handleStaffGeneratePerformanceReport(staff);
                break;
            case "7":
                //Generate Enquiries Report
                handleStaffGenerateEnquiriesReport(staff);
                break;

            case "8":
                // View suggestions to staff's camps 
                handleStaffViewSuggestions(staff);
                break;

            case "9":
                // Accept suggetions to staff's camps
                handleStaffAcceptSuggestion(staff);
                break;
                
            case "10":
            //View enquiries
                handleStaffViewEnquiries(staff);
                break;

            case "11":
            //reply enquiries
                handleStaffReplyEnquiries(staff);
            break;

            case "12":
                // Set filter category
                handleStaffSetFilterCategory(staff, campDataBase);
                break;

            case "13":
                // Set filter string
                handleStaffSetFilterString(staff);
                break;

            case "14":
                // Set sorting category
                handleStaffSetSortingCategory(staff, campDataBase);
                break;

            case "15":
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

    public void handleStaffCommandCreateCamp(Staff staff) {
        // handle handle
        System.out.printf("Enter Camp Name: ");
        String campName;
        campName=scanner.nextLine();

        String startDate;
        while(true)
        {
            try
            {
                System.out.printf("Enter Camp Start Date (DD/MM/YYYY): ");
                startDate=scanner.nextLine();
                if(DateUtils.stringToDate(startDate).isBefore(LocalDate.now()))
                {
                    throw new IllegalArgumentException();
                }
                break;
            }
            catch(Exception exception)
            {
                if(exception instanceof IllegalArgumentException)
                {
                    System.out.printf("Can't create a camp with starting date before current date! Try again\n!");
                }
                else
                {
                    System.out.printf("Invalid date format! Try again.\n"); 
                }        
            }
        }

        String endDate;
        while(true)
        {
            try
            {
                System.out.printf("Enter Camp End Date (DD/MM/YYYY): ");
                endDate=scanner.nextLine();
                if(DateUtils.stringToDate(endDate).isBefore(DateUtils.stringToDate(startDate)) || DateUtils.stringToDate(endDate).isBefore(LocalDate.now()))
                {
                    throw new IllegalArgumentException();   
                }
                break;
            }
            catch(Exception exception)
            {
                if(exception instanceof IllegalArgumentException)
                {
                    System.out.println("Error! End date must be after start date! Try again!");
                }
                else
                {
                    System.out.printf("Invalid date format! Try again.\n");
                }
            }
        }
        

        String regClosingDate;
        while(true)
        {
            try
            {
                System.out.printf("Enter Camp Registration Closing Date (DD/MM/YYYY): ");
                regClosingDate=scanner.nextLine();
                if(DateUtils.stringToDate(regClosingDate).isAfter(DateUtils.stringToDate(endDate)))
                {
                    throw new IllegalArgumentException();
                }
                break;
            }
            catch(Exception exception)
            {
                if(exception instanceof IllegalArgumentException)
                {
                    System.out.printf("Can't create a camp with starting date before current date! Try again!\n");
                }
                else
                {
                      System.out.printf("Invalid date format! Try again.\n");
                }
            }
        }
        
       
        boolean visibility;
        while(true)
        {
            try
            {
                System.out.printf("Enter Camp Registration starting visibility (true or false): ");
                String input=scanner.nextLine();
                if((!input.toLowerCase().equals("true")) && !(input.toLowerCase().equals("false")))
                {
                    throw new Exception();
                }
                visibility=Boolean.valueOf(input);
                break;
            }
            catch(Exception exception)
            {        
                System.out.printf("Invalid visibility was keyed in! Please try again.\n");
            }
        }
        


        System.out.printf("Enter Camp Location: ");
        String location;
        location=scanner.nextLine();
        
        int attendeeSlots;
        while(true)
        {
            try
            {
                System.out.printf("Enter Attendee Slots: ");
                attendeeSlots=scanner.nextInt();
                scanner.nextLine();
                break;
            }
            catch(Exception exception)
            {
                scanner.nextLine();
                System.out.printf("Invalid input. Please enter an integer value!\n");
            }
        }
        
        
        int campComSlots;
        while(true)
        {
            try
            {
                System.out.printf("Enter Camp Committee Slots: ");
                campComSlots=scanner.nextInt();
                if(campComSlots>10)
                {
                    throw new IllegalArgumentException();
                }
                scanner.nextLine();
                break;
            }
            catch(Exception exception)
            {
                scanner.nextLine();
                if(exception instanceof InputMismatchException)
                {
                    System.out.printf("Invalid input! Please enter an integer value!\n");
                }
                else
                {
                    System.out.printf("Invalid input! Maximum camp committee slots is 10! Please try again.\n");
                }
            }
        }
        
        

        System.out.printf("Enter Camp Description: ");
        String description;
        description=scanner.nextLine();


        Faculty openTo;
        while(true)
        {
            try
            {
                System.out.printf("Enter Faculty it is open to (ALL CAPS, i.e SCSE): ");
                openTo=Faculty.valueOf(scanner.nextLine());
                break;
            }
            catch(Exception exception)
            {
                System.out.printf("Invalid input! Please enter a valid faculty in all caps! Try again.\n");   
            }
        }
        


        staff.createCamp(campName, startDate, endDate, regClosingDate, visibility, location, attendeeSlots, campComSlots, description, openTo);

        // ==> quay lai log out

    }

    public void handleStaffCommandDeleteCamp(Staff staff) {
        // Handle register for a camp command
        staff.viewOwnCamps();
        String campName;
        System.out.printf("Enter camp name of the camp you want to delete: ");
        campName = scanner.nextLine();
        staff.deleteCamp(campName);
    }

    public void handleStaffCommandEditCamp(Staff staff) {
        // Handle deregister from registered camp command
        staff.viewOwnCamps();
        String campName;
        System.out.printf("Enter the camp name of the camp you want to edit: ");
        campName = scanner.nextLine(); 

        Message.printDivider();
        Message.printCampEditCommands();
        System.out.printf("Type index for command (enter any other value to exit!): ");

        String s = scanner.nextLine().trim();

        switch(s) {
            case "1":
            System.out.printf("Enter the visibility you want for this camp: ");
            boolean newVisibility = scanner.nextBoolean();
            scanner.nextLine();
            staff.changeVisibility(campName,newVisibility);
            //System.out.println("Visibility successfully changed!");
            break;

            case "2":
            Message.printEditSlots();
            Message.askForInput();
            String s2 = scanner.nextLine().trim();
            switch(s2) {
                case "a":
                    System.out.printf("Enter the new number committee slots: ");
                    int newCampComSlots = scanner.nextInt();
                    scanner.nextLine();
                    staff.changeCampComSlots(campName,newCampComSlots);
                    System.out.println("Number of committee slots changed!");
                    staff.viewOwnCamps();
                    break;

                case "b":
                    System.out.printf("Enter the new number of attendee slots: ");
                    int newAttendeeSlots = scanner.nextInt();
                    scanner.nextLine();
                    staff.changeAttendeeSlots(campName, newAttendeeSlots);
                    System.out.println("Number of attendee slots changed!");
                    staff.viewOwnCamps();
                    break;
                }
            break;

            case "3":
            System.out.printf("Enter the new location for this camp: ");
            String newLocation=scanner.nextLine();
            staff.changeLocation(campName, newLocation);
            break;

            case "4":
            System.out.printf("Enter the new description for this game: ");
            String newDescription=scanner.nextLine();
            staff.changeDescription(campName, newDescription);
            break;

            case "5":
            System.out.printf("Enter the new starting date for this camp (DD/MM/YYYY): ");
            String newDate=scanner.nextLine();
            staff.changeStartDate(campName, newDate);
            break;

            case "6":
            System.out.printf("Enter the new ending date for this camp (DD/MM/YYYY): ");
            String endDate=scanner.nextLine();
            staff.changeEndDate(campName, endDate);
            break;

            case "7":
            System.out.printf("Enter the new registration closing date for this camp (DD/MM/YYYY): ");
            String newRegClose=scanner.nextLine();
            staff.changeStartDate(campName, newRegClose);
            break;
        }
    }

    public void handleStaffViewCamps(Staff staff) {
        // Handle view all camps
        System.out.printf("Enter option to view! (enter any other value to return to menu)\n\na. View all camps \nb. View your created camps \n");
        Message.printDivider();
        Message.askForInput();

        String s = scanner.nextLine().trim();
        switch(s) {
            case "a":
            staff.viewAllCamps();
            break;
            case "b":
            staff.viewOwnCamps();
            break;
        }
    }

    public void handleStaffGenerateStudentReport(Staff staff) {
        //// Handle view registered camps command
        staff.generateStudentReport();
    }
     public void handleStaffGeneratePerformanceReport(Staff staff) {
        //// Handle view registered camps command
        staff.generatePerformanceReport();
    }

    public void handleStaffGenerateEnquiriesReport(Staff staff)
    {
        System.out.printf("Enter the name of the file you would like to generate the report in: ");
        String fileName=scanner.nextLine();
        enquiriesDB.enquiryReport(staff.getCampsCreated(),fileName);
    }

    public void handleStaffViewSuggestions(Staff staff)
    {
        suggestionsDB.viewByCamp(staff.getCampsCreated());
    }

    public void handleStaffAcceptSuggestion(Staff staff)
    {
        suggestionsDB.viewByCamp(staff.getCampsCreated());
        System.out.printf("Enter suggestion ID of suggestion to accept: ");
        int suggestionID=scanner.nextInt();
        scanner.nextLine();
        String studentWhoSuggested=suggestionsDB.approveSuggestion(suggestionID, staff.getCampsCreated());
        if(studentWhoSuggested!=null)
        {
            dataList.addPoints(studentWhoSuggested);
            System.out.println("Added points to the camp committee member who gave that suggestion!");
        }

    }

    public void handleStaffViewEnquiries(Staff staff)
    {
        enquiriesDB.viewByCamp(staff.getCampsCreated());
    }

    public void handleStaffReplyEnquiries(Staff staff)
    {
        enquiriesDB.viewByCamp(staff.getCampsCreated());
        System.out.printf("Enter which enquiry number you want to reply to: ");
        int enquiryNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Enter your reply: ");
        String text = scanner.nextLine();
        enquiriesDB.addReply(enquiryNumber, text,staff.getCampsCreated());  
    }

    public void handleStaffSetFilterCategory(Staff staff,CampDataBase campDataBase)
    {

        Message.printFilterCategoryCommands();

        System.out.printf("Enter which filter category you would like to select: ");
        String input=scanner.nextLine();

        switch(input)
        {
            case "1":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByNothing());
            break;

            case "2":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
            break;

            case "3":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByStartDate());
            break;

            case "4":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByEndDate());
            break;

            case "5":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByRegClosingDate());
            break;

            case "6":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByVisibility());
            break;

            case "7":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
            break;

            case "8":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByTotalSlots());
            break;

            case "9":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeSlots());
            break;

            case "10":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
            break;

            case "11":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableAttendeeSlots());
            break;

            case "12":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableCampComSlots());
            break;

            case "13":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByStaffIC());
            break;

            case "14":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByOpenTo());
            break;

            case "15":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeName());
            break;

            case "16":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCommitteeName());
            break;

            case "17":
            staff.setCampFilter(campDataBase.getFilterManager().getFilterCampByDescription());
            break;

            default:
            System.out.println("Invalid filter option! Returning to menu...\n");
            return;
        }
        System.out.println("Filter set successfully! Camps will be filtered by this category using your filter string when viewing camps or generating reports.");
        
    }

    public void handleStaffSetFilterString(Staff staff)
    {
        System.out.println("Enter what you would like to find based on your filter category.");
        System.out.println("Example:\nIf filtering by Visibility status, input True or False.");
        System.out.println("If filtering by Location, input the name of the location.");
        System.out.printf("Input: ");
        String input=scanner.nextLine();
        staff.setFilterString(input);
        System.out.println("Filter string set! Camps will be filtered with this string using your corresponding filter category when viewing camps or generating reports.");

    }

    public void handleStaffSetSortingCategory(Staff staff,CampDataBase campDataBase)
    {

        Message.printSortingCategoryCommands();

        System.out.printf("Enter which sorting category you would like to select: ");
        String input=scanner.nextLine();

        switch(input)
        {
            case "1":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByCampName());
            break;

            case "2":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByStartDate());
            break;

            case "3":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByEndDate());
            break;

            case "4":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByRegDate());
            break;

            case "5":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByVisibility());
            break;

            case "6":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByLocation());
            break;

            case "7":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByTotalSlots());
            break;

            case "8":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByAttendeeSlots());
            break;

            case "9":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByCampComSlots());
            break;

            case "10":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByAvailableAttendeeSlots());
            break;

            case "11":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByAvailableCampCommiteeSlots());
            break;

            case "12":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByDescription());
            break;

            case "13":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByStaffIC());
            break;

            case "14":
            staff.setCampSorter(campDataBase.getSortManager().getSortCampByOpenTo());
            break;
            
            default:
            System.out.println("Invalid sorting option! Returning to menu...\n");
            return;
        }
        System.out.println("Sorting preference set successfully! Camps will now be sorted in this order when viewing or generating reports.");
        
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
