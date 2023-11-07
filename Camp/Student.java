package camp;

public class Student extends User
{
    private Faculty faculty;
    private IViewAllCamps StudentViewAllCamps;

    public Student(String name,IViewAllCamps StudentViewAllCamps,Faculty faculty,IFilterCamps iFilterCamps)
    {
        super(name,iFilterCamps);
        this.StudentViewAllCamps=StudentViewAllCamps;
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
        StudentViewAllCamps.viewAllCamps(this,super.getFilterCamps());
    }

}
