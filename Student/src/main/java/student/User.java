package student;
import java.util.Objects;

public class User {
    protected String name;
    protected String password;
    protected String facultyInformation;

    public User(String name, String password, String facultyInformation) {
        this.name = name;
        this.password = password;
        this.facultyInformation = facultyInformation;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacultyInformation() {
        return this.facultyInformation;
    }

    public void setFacultyInformation(String facultyInformation) {
        this.facultyInformation = facultyInformation;
    }

    public User name(String name) {
        setName(name);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User facultyInformation(String facultyInformation) {
        setFacultyInformation(facultyInformation);
        return this;
    }
    
}
