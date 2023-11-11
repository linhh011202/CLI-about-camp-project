package merge;


public class Student extends User
{
    private Faculty faculty;
    private boolean isCommittee;

    //Interfaces it uses
    private IViewAllCamps studentViewAllCamps;
    private IRegisterCamp studentCampRegisterer;
    private IDeregisterCamp studentCampDeregisterer;
    private IRegisterCommittee committeeCampRegisterer;
    private IViewRegisteredCamps studentRegisteredCampsViewer;
    private IGenerateStudentReport campComStudentReportGenerator;

    public Student(String name,IViewAllCamps studentViewAllCamps,Faculty faculty,ISortCamps iSortCamps, IRegisterCamp studentCampRegisterer,IDeregisterCamp studentCampDeregisterer,IRegisterCommittee commiteeCampRegisterer, IViewRegisteredCamps studentRegisteredCampsViewer,IFilterCamps iFilterCamps,IGenerateStudentReport campComStudentReportGenerator)
    {
        super(name,iSortCamps,iFilterCamps);
        this.isCommittee=false;
        this.studentViewAllCamps=studentViewAllCamps;
        this.faculty=faculty;
        this.studentCampRegisterer=studentCampRegisterer;
        this.studentCampDeregisterer=studentCampDeregisterer;
        this.committeeCampRegisterer=commiteeCampRegisterer;
        this.studentRegisteredCampsViewer=studentRegisteredCampsViewer;
        this.campComStudentReportGenerator=campComStudentReportGenerator;
    }

    //Copy constructor
    public Student(Student student)
    {
        super(student.getName(),student.getSortCamps(),student.getFilterCamps());
        this.isCommittee=student.getIsCommittee();
        this.faculty=student.getFaculty();
        this.studentViewAllCamps=student.getStudentViewAllCamps();
        this.studentCampRegisterer=student.getStudentCampRegisterer();
        this.studentCampDeregisterer=student.getStudentCampDeregisterer();
        this.committeeCampRegisterer=student.getCommitteeCampRegisterer();
        this.studentRegisteredCampsViewer=student.getStudentRegisteredCampsViewer();
        this.campComStudentReportGenerator=student.getCampComStudentReportGenerator();
    }


    //Getters and Setters
    public Faculty getFaculty()
    {
        return faculty;
    }

    public void setFaculty(Faculty faculty)
    {
        this.faculty=faculty;
    }

    public boolean getIsCommittee(){return isCommittee;}

    public void setIsCommittee(boolean isCommittee){this.isCommittee=isCommittee;}

    public IViewAllCamps getStudentViewAllCamps()
    {
        return studentViewAllCamps;
    }

    public IRegisterCamp getStudentCampRegisterer()
    {
        return studentCampRegisterer;
    }

    public IDeregisterCamp getStudentCampDeregisterer()
    {
        return studentCampDeregisterer;
    }

    public IRegisterCommittee getCommitteeCampRegisterer()
    {
        return committeeCampRegisterer;
    }

    public IViewRegisteredCamps getStudentRegisteredCampsViewer()
    {
        return studentRegisteredCampsViewer;
    }

    public IGenerateStudentReport getCampComStudentReportGenerator()
    {
        return campComStudentReportGenerator;
    }


    //Testing Functions:
    public void viewAllCamps()
    {
        studentViewAllCamps.viewAllCamps(this,getSortCamps(),getFilterCamps(),getFilterString());
    }

    public void registerCampStudent(String campName)
    {
        studentCampRegisterer.registerCamp(this,campName);
    }

    public void deregisterCamp(String campName)
    {
        studentCampDeregisterer.deregisterCamp(this, campName);
    }

    public Student registerCampCommittee(String campName)
    {
        return committeeCampRegisterer.registerCamp(this, campName);
    }

    public void viewRegisteredCamps()
    {
        studentRegisteredCampsViewer.viewRegisteredCamps(this,getSortCamps(),getFilterCamps(),getFilterString());
    }

    public void generateCampComReport()
    {
        campComStudentReportGenerator.generateStudentReport(this, getSortCamps(), getFilterCamps(), getFilterString());
    }


}