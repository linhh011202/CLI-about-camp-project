package main.utils;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;
import main.user.DataList;

public class Message {

   
    public static final String START = "Hi user. This is the start";
    public static final String LOADING ="Finish Loading Files";


    public static final String ENTER_USERNAME_PASSWORD = "Please enter your name and password";
    public static final String USERNAME = "Username: ";
    public static final String PASSWORD = "Password: ";
    public static final String WELCOME = "Welcome, ";
    public static final String FAILED = "Authentication failed: "; 
    private static final String DIVIDER = "===================================================";
    public static final String HELLO = "Welcome to the NTU Camp System!\n"
    + "To login, type \"login\"\n"
    + "To exit, type \"exit\"\n"
    + DIVIDER;  // Concatenate DIVIDER here


    public static final String STUDENTCOMMANDS= "Here are list of Student Commands:\n"
        +"0.Change password\n"
        +"1.Register for a camp\n"
        +"2.Deregister from registered camp\n"
        +"3.Register as a Camp Committee\n"
        +"4.View all available camps\n"
        +"5.View registered camps\n"
        +"6.Committee Commands (only if committee member)\n"
        +"7.View own submitted enquiries\n"
        +"8.Send an enquiry\n"
        +"9.Edit an enquiry\n"
        +"10.Delete an enquiry\n"
        +"11.Set filter category\n"
        +"12.Set filter string\n"
        +"13.Set sorting category\n"
        +"14.Log Out\n";

    public static final String STUDENTCOMMITTEECOMMANDS= "Here are the list of camp committee commands: \n"
        +"1. Send suggestions to staff\n"
        +"2. View your suggestions\n"
        +"3. Edit your suggestions\n"
        +"4. Delete suggestion\n"
        +"5. View student enquiries\n"
        +"6. Reply student enquiries\n"
        +"7. Generate report\n"
        +DIVIDER;
        
    public static final String STAFFCOMMANDS= "Here are list of Staff Commands:\n"
            +"0.Change password\n"
            +"1.View camps\n"
            +"2.Create camp\n"
            +"3.Delete Camp\n"
            +"4.Edit camp\n" 
            +"5.Generate Student Report\n" 
            +"6.Generate Performance Report\n" 
            +"7.View suggestions to your camps\n" 
            +"8.Approve suggestions to your camps\n" 
            +"9.View enquiries for your camps\n"
            +"10.Reply to enquiries for your camps\n"
            +"11.Set filter category Performance Report\n" 
            +"12.Set filter string\n" 
            +"13.Set sorting category\n" 
            +"14.Log out\n";
            
            
    public static final String STAFFEDITCOMMANDS= "Here are the list of edit camp commands: \n"
            +"1. Change camp name\n"
            +"2. Change visibility\n"
            +"3. Change number of slots\n"
            +"4. Change camp location\n"
            +"5. Change camp description\n"
            +"6. Change starting date\n"
            +"7. Change ending date\n"
            +"8. Change registration closing date\n"
            +DIVIDER;

    public static final String STAFFEDITSLOTS= "Which slot would you like to edit? \n"
            +"a. Committee slots\n"
            +"b. Attendee slots\n"
            +DIVIDER;

    private static final String EXIT_OR_LOGIN = "Type the index for command: ";

    public static final String FILTERCATEGORYCOMMANDS= "Here are the list of Filter Categories:\n"
    +"1.No Filter\n"
    +"2.Filter by Camp Name\n"
    +"3.Filter by Camp Start Date\n"
    +"4.Filter by Camp End Date\n"
    +"5.Filter by Camp Registration Closing Date\n"
    +"6.Filter by Camp Visibility Status\n"
    +"7.Filter by Camp Location\n"
    +"8.Filter by Camp Total Slots\n"
    +"9.Filter by Camp Total Camp Attendee Slots\n"
    +"10.Filter by Camp Total Camp Committee Slots\n"
    +"11.Filter by Camp Available Camp Attendee Slots\n"
    +"12.Filter by Camp Available Camp Committee Slots\n"
    +"13.Filter by Camp Staff-In-Charge Name\n"
    +"14.Filter by Camp Faculty Name\n"
    +"15.Filter by Camp Attendee Name\n"
    +"16.Filter by Camp Committee Name\n"
    +"17.Filter by Camp Description\n";

    public static final String SORTCATEGORYCOMMANDS= "Here are the list of Sorting Categories:\n"
    +"1.Sort by Camp Name (Default)\n"
    +"2.Sort by Camp Start Date\n"
    +"3.Sort by Camp End Date\n"
    +"4.Sort by Camp Registration Closing Date\n"
    +"5.Sort by Camp Visibility Status\n"
    +"6.Sort by Camp Location\n"
    +"7.Sort by Total Slots\n"
    +"8.Sort by Total Camp Attendee Slots\n"
    +"9.Sort by Total Camp Committee Slots\n"
    +"10.Sort by Available Camp Attendee Slots\n"
    +"11.Sort by Available Camp Committee Slots\n"
    +"12.Sort by Camp Description \n"
    +"13.Sort by Camp Staff-In-Charge Name\n"
    +"14.Sort by Camp Faculty Name\n";
    


    public static void printDivider(){
        System.out.println(DIVIDER);
    }

    public static void printUsernameMessage(){
        System.out.print(USERNAME);


    }
    public static void printPassWordMessage(){
        System.out.print(PASSWORD);


    }
    public static void printUsernamePasswordPrompt(){
        System.out.println(ENTER_USERNAME_PASSWORD);

    }

    public static void printAllStudentCommands(){
        Message.printDivider();
        System.out.println(STUDENTCOMMANDS); 
    }

    public static void printCommitteeCommands(){
        Message.printDivider();
        System.out.println(STUDENTCOMMITTEECOMMANDS);
    }

    public static void printAllStaffCommands(){
        Message.printDivider();
        System.out.println(STAFFCOMMANDS); 
    }

    public static void printCampEditCommands(){
        System.out.println(STAFFEDITCOMMANDS);
    }

    public static void printEditSlots(){
        System.out.println(STAFFEDITSLOTS);
    }
    
    public static void askForInput(){
        System.out.println(EXIT_OR_LOGIN);
    }

    public static void printFilterCategoryCommands()
    {
        System.out.println(FILTERCATEGORYCOMMANDS);
    }

    public static void printSortingCategoryCommands()
    {
        System.out.println(SORTCATEGORYCOMMANDS);
    }



}




    

    

    
    
