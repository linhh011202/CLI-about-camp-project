package utils;

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
        +"4.View registered camps\n"
        +"5.Generate Report\n"
        +"6.Log Out\n";
        
    public static final String STAFFCOMMANDS= "Here are list of Staff Commands:\n"
            +"0.Change password\n"
            +"1.Create camp\n"
            +"2.Delete Camp\n"
            +"3.Edit camp\n" 
            +"4.Generate Student Report\n" 
            +"5.Generate Performance Report\n" 
            +"6.Log out\n";
            
    

    private static final String EXIT_OR_LOGIN = "Type the index for command";

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
        System.out.println(STUDENTCOMMANDS); 
    }

    public static void printAllStaffCommands(){
        System.out.println(STAFFCOMMANDS); 
    }
    



}




    

    

    
    
