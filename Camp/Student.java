package camp;

public class Student extends User
{
    private Faculty faculty;
    private IViewAllCamps iViewAllCamps;

    public Student(String name,IViewAllCamps iViewAllCamps,Faculty faculty)
    {
        super(name);
        this.iViewAllCamps=iViewAllCamps;
        this.faculty=faculty;
    }

    public Faculty getFaculty()
    {
        return faculty;
    }

    public void setFaculty(Faculty faculty)
    {
        this.faculty=faculty;
    }

    public void viewAllCamps()
    {
        iViewAllCamps.viewAllCamps(this);
    }

}
