package camp;

public class Student extends User
{
    private Faculty faculty;
    private IViewAllCamps studentViewAllCamps;
    private IRegisterCamp studentCampRegisterer;
    private IDeregisterCamp studentCampDeregisterer;

    public Student(String name,IViewAllCamps studentViewAllCamps,Faculty faculty,IFilterCamps iFilterCamps, IRegisterCamp studentCampRegisterer,IDeregisterCamp studentCampDeregisterer)
    {
        super(name,iFilterCamps);
        this.studentViewAllCamps=studentViewAllCamps;
        this.faculty=faculty;
        this.studentCampRegisterer=studentCampRegisterer;
        this.studentCampDeregisterer=studentCampDeregisterer;
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
        studentViewAllCamps.viewAllCamps(this,super.getFilterCamps());
    }

    public void registerCampStudent(String campName)
    {
        studentCampRegisterer.registerCamp(this,campName);
    }

    public void deregisterCamp(String campName)
    {
        studentCampDeregisterer.deregisterCamp(this, campName);
    }

}
