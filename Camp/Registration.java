package camp;

public class Registration 
{
    private String studentName;
    private String campName;
    private String role;
    private boolean deregistered;
    
    Registration(String studentName, String campName,String role)
    {
        this.studentName=studentName;
        this.campName=campName;
        this.role=role;
        this.deregistered=false;
    }

    public void printRegistration()
    {
        System.out.printf("|| Camp Name: %s | Student Name: %s | Role: %s | Is this entry Deregistered: %b ||");
        return;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public String getCampName()
    {
        return campName;
    }

    public String getRole()
    {
        return role;
    }

    public boolean getDeregistered()
    {
        return deregistered;
    }
}
