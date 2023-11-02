package camp;

public class Staff extends User
{
    private ICreateCamp iCreateCamp;
    private IDeleteCamp iDeleteCamp;
    private IEditCamp iEditCamp;
    private IViewAllCamps iViewAllCamps;
    private IViewOwnCamps iViewOwnCamps;

    public Staff(String name,ICreateCamp iCreateCamp,IDeleteCamp iDeleteCamp,IEditCamp iEditCamp,IViewAllCamps iViewAllCamps,IViewOwnCamps iViewOwnCamps)
    {
        super(name);
        this.iCreateCamp=iCreateCamp;
        this.iDeleteCamp=iDeleteCamp;
        this.iEditCamp=iEditCamp;
        this.iViewAllCamps=iViewAllCamps;
        this.iViewOwnCamps=iViewOwnCamps;
    }

    public void createCamp(String campName,String startDate,String endDate, String regClosingDate,boolean visibility, String location, int totalSlots,int campComSlots,String description,Faculty openTo)
    {
        iCreateCamp.createCamp(campName, startDate,endDate, regClosingDate, visibility, location, totalSlots, campComSlots, description, this, openTo);
    }
    public void deleteCamp(String campName)
    {
        iDeleteCamp.deleteCamp(this,campName);
    }
    public void changeCampName(String campName,String newCampName)
    {
        iEditCamp.changeCampName(this,campName,newCampName);
    }
     public void changeVisibility(String campName,boolean newVisibility)
    {
        iEditCamp.changeVisibility(this,campName,newVisibility);
    }
    public void viewAllCamps()
    {
        iViewAllCamps.viewAllCamps(this);
    }
    public void viewOwnCamps()
    {
        iViewOwnCamps.viewOwnCamps(this);
    }

}
