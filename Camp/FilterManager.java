package camp;

public class 
FilterManager 
{
    private CampDataBase campDataBase;

    private FilterCampByCampName filterCampByCampName;
    private FilterCampByStartDate filterCampByStartDate;
    private FilterCampByEndDate filterCampByEndDate;
    private FilterCampByRegDate filterCampByRegDate;
    private FilterCampByVisibility filterCampByVisibility;
    private FilterCampByLocation filterCampByLocation;
    private FilterCampByTotalSlots filterCampByTotalSlots;
    private FilterCampByCampComSlots filterCampByCampComSlots;
    private FilterCampByDescription filterCampByDescription;
    private FilterCampByStaffIC filterCampByStaffIC;
    private FilterCampByOpenTo filterCampByOpenTo;
    private FilterCampByAttendeeSlots filterCampByAttendeeSlots;
    private FilterCampByAvailableAttendeeSlots filterCampByAvailableAttendeeSlots;
    private FilterCampByAvailableCampCommiteeSlots filterCampByAvailableCampCommiteeSlots;

    public FilterManager(CampDataBase campDataBase)
    {
        this.campDataBase=campDataBase;
        this.filterCampByCampName=new FilterCampByCampName(this);
        this.filterCampByStartDate=new FilterCampByStartDate(this);
        this.filterCampByEndDate=new FilterCampByEndDate(this);
        this.filterCampByRegDate=new FilterCampByRegDate(this);
        this.filterCampByVisibility=new FilterCampByVisibility(this);
        this.filterCampByLocation=new FilterCampByLocation(this);
        this.filterCampByTotalSlots=new FilterCampByTotalSlots(this);
        this.filterCampByCampComSlots=new FilterCampByCampComSlots(this);
        this.filterCampByDescription=new FilterCampByDescription(this);
        this.filterCampByStaffIC=new FilterCampByStaffIC(this);
        this.filterCampByOpenTo=new FilterCampByOpenTo(this);
        this.filterCampByAttendeeSlots=new FilterCampByAttendeeSlots(this);
        this.filterCampByAvailableAttendeeSlots=new FilterCampByAvailableAttendeeSlots(this);
        this.filterCampByAvailableCampCommiteeSlots=new FilterCampByAvailableCampCommiteeSlots(this);
    }

    //Getters for these classes so User class can set their filters as these guys, and pass the param to the ViewCamps interface call
    //these will be upcast back as interface when placed in user class.

    public FilterCampByCampName getFilterCampByCampName(){return filterCampByCampName;}
    public FilterCampByStartDate getFilterCampByStartDate(){return filterCampByStartDate;}
    public FilterCampByEndDate getFilterCampByEndDate(){return filterCampByEndDate;}
    public FilterCampByRegDate getFilterCampByRegDate(){return filterCampByRegDate;}
    public FilterCampByVisibility getfilterCampByVisibility(){return filterCampByVisibility;}
    public FilterCampByLocation getFilterCampByLocation(){return filterCampByLocation;}
    public FilterCampByTotalSlots getFilterCampByTotalSlots(){return filterCampByTotalSlots;}
    public FilterCampByCampComSlots getFilterCampByCampComSlots(){return filterCampByCampComSlots;}
    public FilterCampByDescription getFilterCampByDescription(){return filterCampByDescription;}
    public FilterCampByStaffIC getFilterCampByStaffIC(){return filterCampByStaffIC;}
    public FilterCampByOpenTo getFilterCampByOpenTo(){return filterCampByOpenTo;}
    public FilterCampByAttendeeSlots getFilterCampByAttendeeSlots(){return filterCampByAttendeeSlots;}
    public FilterCampByAvailableAttendeeSlots getFilterCampByAvailableAttendeeSlots(){return filterCampByAvailableAttendeeSlots;}
    public FilterCampByAvailableCampCommiteeSlots getFilterCampByAvailableCampCommiteeSlots(){return filterCampByAvailableCampCommiteeSlots;}
    

    public CampDataBase getCampDataBase()
    {
        return campDataBase;
    }
}
