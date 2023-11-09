package camp;

public class Staff extends User
{
    private ICreateCamp staffCampCreator;
    private IDeleteCamp staffCampDeleter;
    private IEditCamp staffCampEditor;
    private IViewAllCamps staffViewAllCamps;
    private IViewOwnCamps staffViewOwnCamps;
   

    public Staff(String name,ICreateCamp staffCampCreator,IDeleteCamp staffCampDeleter,IEditCamp staffCampEditor,IViewAllCamps staffViewAllCamps,IViewOwnCamps staffViewOwnCamps,ISortCamps iSortCamps)
    {
        super(name,iSortCamps);
        this.staffCampCreator=staffCampCreator;
        this.staffCampDeleter=staffCampDeleter;
        this.staffCampEditor=staffCampEditor;
        this.staffViewAllCamps=staffViewAllCamps;
        this.staffViewOwnCamps=staffViewOwnCamps;
        
        
    }

    public void createCamp(String campName,String startDate,String endDate, String regClosingDate,boolean visibility, String location, int attendeeSlots,int campComSlots,String description,Faculty openTo)
    {
        staffCampCreator.createCamp(campName, startDate,endDate, regClosingDate, visibility, location, attendeeSlots, campComSlots, description, this, openTo);
    }
    public void deleteCamp(String campName)
    {
        staffCampDeleter.deleteCamp(this,campName);
    }
    public void changeCampName(String campName,String newCampName)
    {
        staffCampEditor.changeCampName(this,campName,newCampName);
    }
     public void changeVisibility(String campName,boolean newVisibility)
    {
        staffCampEditor.changeVisibility(this,campName,newVisibility);
    }
    public void changeCampComSlots(String campName,int newCampComSlots)
    {
        staffCampEditor.changeCampComSlots(this,campName,newCampComSlots);
    }
    public void changeAttendeeSlots(String campName,int newAttendeeSlots)
    {
        staffCampEditor.changeAttendeeSlots(this,campName,newAttendeeSlots);
    }
    public void viewAllCamps()
    {
        staffViewAllCamps.viewAllCamps(this,super.getSortCamps());
    }
    public void viewOwnCamps()
    {
        staffViewOwnCamps.viewOwnCamps(this,super.getSortCamps());
    }


}
