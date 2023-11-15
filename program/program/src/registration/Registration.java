package registration;

import camp;
import enquiries;
import misc;
import suggestions;
import user;

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
        System.out.printf("|| Camp Name: %s | Student Name: %s | Role: %s | Is this entry Deregistered: %b ||\n",campName,studentName,role,deregistered);
        return;
    }

    public String getStudentName()
    {
        return studentName;
    }
    public void setStudentName(String studentName)
    {
        this.studentName=studentName;
    }

    public String getCampName()
    {
        return campName;
    }
    public void setCampName(String campName)
    {
        this.campName=campName;
    }

    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role=role;
    }

    public boolean getDeregistered()
    {
        return deregistered;
    }
    public void setDeregistered(boolean deregistered)
    {
       this.deregistered=deregistered;
    }
}
