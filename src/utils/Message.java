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

    



}




    

    

    
    
