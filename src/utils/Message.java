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
            +"1.Edit password\n"
            +"2.Log out\n"
            +"3.Register for a camp\n" 
            +"4.Deregister from registered camp\n" 
            +"5.Register as a Camp Committee\n" 
            +"6.View registered camps\n"; 
    public static final String STAFFCOMMANDS= "Here are list of Staff Commands:\n "
        +"1. blabla"
        +"2.hiiiiiiiiiiiiiiiii"
        +"3.hhhhhhhhhhhhhhhh"; 
            

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




    

    

    
    
