package merge;

public class CampCommittee extends Student
{
    private int points=0;
    private String campName;

    public CampCommittee(Student student,String campName)
    {
        //Uses copy constructor for superClass to copy everything in. 
        super(student);
        super.setIsCommittee(true);
        this.campName=campName;
    }

    public String getCampName() {
        return campName;
    }

}