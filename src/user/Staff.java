package user;


// Staff and Student are a type of user, so I will use the idea of parenting or interface to implement this

// We can define a constructor here. But since they are all user and have the same way of constructing. It is better to define it in the User.java
public class Staff extends User{
    public String type = "Staff"; // Staff have a type of Staff

    public Staff(String name, String email, String faculty){
        super(name, email, faculty); // super refer to the PARENT
    }
}
