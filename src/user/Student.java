package user;

public class Student extends User{
    public String type = "Student"; // Student have a type of Student

    public Student(String name, String email, String faculty){
        super(name, email, faculty); // super refer to the PARENT
    }

}
