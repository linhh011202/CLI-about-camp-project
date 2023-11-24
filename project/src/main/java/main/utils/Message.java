package main.utils;


/** 
 * A class that consolidates message information for organisation, and provides static functions so these messages can be easily printed.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-24
*/
public class Message {
    /**
     * Mesasge sent when files are done loading.
     */
    public static final String LOADING ="Finish Loading Files";

    /**
     * Message sent to request for username and password.
     */
    public static final String ENTER_USERNAME_PASSWORD = "Please enter your name and password";

    /**
     * Message to display username.
     */
    public static final String USERNAME = "Username: ";

    /**
     * Message to display password.
     */
    public static final String PASSWORD = "Password: ";

    /**
     * Message to display welcome message.
     */
    public static final String WELCOME = "Welcome, ";

    /**
     * Message to be displayed on authentication failure.
     */
    public static final String FAILED = "Authentication failed: "; 

    /**
     * Message containing a divider.
     */
    private static final String DIVIDER = "===================================================";

    /**
     * Message containing a welcome message.
     */
    public static final String HELLO = "Welcome to the NTU Camp System!\n"
    + "To login, type \"login\"\n"
    + "To exit, type \"exit\"\n"
    + DIVIDER;  // Concatenate DIVIDER here


    /**
     * Message containing list of all possible student commands.
     */
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

    /**
     * Message containing list of all student committee commands.
     */
    public static final String STUDENTCOMMITTEECOMMANDS= "Here are the list of camp committee commands\n(Enter any other value to return to main menu): \n"
        +"1. Send suggestions to staff\n"
        +"2. View your suggestions\n"
        +"3. Edit your suggestions\n"
        +"4. Delete suggestion\n"
        +"5. View student enquiries\n"
        +"6. Reply student enquiries\n"
        +"7. Generate camp report\n"
        +"8. Generate enquiries report\n"
        +DIVIDER;
        
    /**
     * Message containing list of all staff commands.
     */
    public static final String STAFFCOMMANDS= "Here are list of Staff Commands:\n"
            +"0.Change password\n"
            +"1.View camps\n"
            +"2.Create camp\n"
            +"3.Delete Camp\n"
            +"4.Edit camp\n" 
            +"5.View registered student list for camp.\n"
            +"6.Generate Student Report\n" 
            +"7.Generate Performance Report\n" 
            +"8.Generate Enquiries Report\n"
            +"9.View suggestions to your camps\n" 
            +"10.Approve suggestions to your camps\n" 
            +"11.View enquiries for your camps\n"
            +"12.Reply to enquiries for your camps\n"
            +"13.Set filter category Performance Report\n" 
            +"14.Set filter string\n" 
            +"15.Set sorting category\n" 
            +"16.Log out\n";
            
            
    /**
     * Message containing list of all staff commands that can be used to edit camps.
     */
    public static final String STAFFEDITCOMMANDS= "Here are the list of edit camp commands: \n"
            +"1. Change visibility\n"
            +"2. Change number of slots\n"
            +"3. Change camp location\n"
            +"4. Change camp description\n"
            +"5. Change starting date\n"
            +"6. Change ending date\n"
            +"7. Change registration closing date\n"
            +"8. Change camp name\n"
            +DIVIDER;


    /**
     * Message containing options when a staff requests to edit the number of slots for his camps.
     */
    public static final String STAFFEDITSLOTS= "Which slot would you like to edit? \n"
            +"a. Committee slots\n"
            +"b. Attendee slots\n"
            +DIVIDER;

    /**
     * Message containing a request to be printed when requesting for the user if they wish to exit or log in.
     */
    private static final String EXIT_OR_LOGIN = "Type the index for command: ";

    /**
     * Message containing list of all filter categories a user can pick from.
     */
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

    /**
     * Message containing list of all sorting categories a user can pick from.
     */
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
    


    /**
     * Prints the divider.
     */
    public static void printDivider(){
        System.out.println(DIVIDER);
    }

    /**
     * Prints the username message.
     */
    public static void printUsernameMessage(){
        System.out.print(USERNAME);
    }

    /**
     * Prints the password message.
     */
    public static void printPassWordMessage(){
        System.out.print(PASSWORD);
    }

    /**
     * Prints the prompt requesting for username and password.
     */
    public static void printUsernamePasswordPrompt(){
        System.out.println(ENTER_USERNAME_PASSWORD);

    }

    /**
     * Prints all student commands.
     */
    public static void printAllStudentCommands(){
        Message.printDivider();
        System.out.println(STUDENTCOMMANDS); 
    }

    /**
     * Prints all camp committee commands.
     */
    public static void printCommitteeCommands(){
        Message.printDivider();
        System.out.println(STUDENTCOMMITTEECOMMANDS);
    }

    /**
     * Prints all staff commands.
     */
    public static void printAllStaffCommands(){
        Message.printDivider();
        System.out.println(STAFFCOMMANDS); 
    }

    /**
     * Prints all options available when editing camps.
     */
    public static void printCampEditCommands(){
        System.out.println(STAFFEDITCOMMANDS);
    }

    /**
     * Prints all categories of slots available to edit, when a staff chooses to edit camp slots.
     */
    public static void printEditSlots(){
        System.out.println(STAFFEDITSLOTS);
    }
    
    /**
     * Prints an output requesting of a user wishes to log in or exit the app.
     */
    public static void askForInput(){
        System.out.println(EXIT_OR_LOGIN);
    }

    /**
     * Prints an output that displays all posssible filter categories that a user can select and set.
     */
    public static void printFilterCategoryCommands()
    {
        System.out.println(FILTERCATEGORYCOMMANDS);
    }

    /**
     * Prints an output that displays all posssible sorting categories that a user can select and set.
     */
    public static void printSortingCategoryCommands()
    {
        System.out.println(SORTCATEGORYCOMMANDS);
    }



}




    

    

    
    
