package user;

// Here we define the thing that all user have in common regardless of Staff or student
public class User {
    public String userID; 
    public String name;
    public String email;
    public String password = "password"; // Remember the requirement is that the default password is password? And the user can also change? So we intialize password as password
    public String faculty; // This can be a string or enum (like one of you have implemented, up to you i don't care)
    public String type; // This could be an enum; either Student or Staff


    public User(String name, String email, String faculty){ // NO void, it is a constructor,
        this.name = name;  // this refer to the INSTANCE
        this.email = email;
        this.faculty = faculty;
        //split string based on @ character and store:
        String[] emailComponents = email.split("@");
        this.userID = emailComponents[0];
        
    }


}
