package camp;

public class SortManager 
{
    private CampDataBase campDataBase;

    private SortCampByCampName sortCampByCampName;
    private SortCampByStartDate sortCampByStartDate;
    private SortCampByEndDate sortCampByEndDate;
    private SortCampByRegDate sortCampByRegDate;
    private SortCampByVisibility sortCampByVisibility;
    private SortCampByLocation sortCampByLocation;
    private SortCampByTotalSlots sortCampByTotalSlots;
    private SortCampByCampComSlots sortCampByCampComSlots;
    private SortCampByDescription sortCampByDescription;
    private SortCampByStaffIC sortCampByStaffIC;
    private SortCampByOpenTo sortCampByOpenTo;
    private SortCampByAttendeeSlots sortCampByAttendeeSlots;
    private SortCampByAvailableAttendeeSlots sortCampByAvailableAttendeeSlots;
    private SortCampByAvailableCampCommiteeSlots sortCampByAvailableCampCommiteeSlots;

    public SortManager(CampDataBase campDataBase)
    {
        this.campDataBase=campDataBase;
        this.sortCampByCampName=new SortCampByCampName(this);
        this.sortCampByStartDate=new SortCampByStartDate(this);
        this.sortCampByEndDate=new SortCampByEndDate(this);
        this.sortCampByRegDate=new SortCampByRegDate(this);
        this.sortCampByVisibility=new SortCampByVisibility(this);
        this.sortCampByLocation=new SortCampByLocation(this);
        this.sortCampByTotalSlots=new SortCampByTotalSlots(this);
        this.sortCampByCampComSlots=new SortCampByCampComSlots(this);
        this.sortCampByDescription=new SortCampByDescription(this);
        this.sortCampByStaffIC=new SortCampByStaffIC(this);
        this.sortCampByOpenTo=new SortCampByOpenTo(this);
        this.sortCampByAttendeeSlots=new SortCampByAttendeeSlots(this);
        this.sortCampByAvailableAttendeeSlots=new SortCampByAvailableAttendeeSlots(this);
        this.sortCampByAvailableCampCommiteeSlots=new SortCampByAvailableCampCommiteeSlots(this);
    }

    //Getters for these classes so User class can set their sorts as these guys, and pass the param to the ViewCamps interface call
    //these will be upcast back as interface when placed in user class.

    public SortCampByCampName getSortCampByCampName(){return sortCampByCampName;}
    public SortCampByStartDate getSortCampByStartDate(){return sortCampByStartDate;}
    public SortCampByEndDate getSortCampByEndDate(){return sortCampByEndDate;}
    public SortCampByRegDate getSortCampByRegDate(){return sortCampByRegDate;}
    public SortCampByVisibility getSortCampByVisibility(){return sortCampByVisibility;}
    public SortCampByLocation getSortCampByLocation(){return sortCampByLocation;}
    public SortCampByTotalSlots getSortCampByTotalSlots(){return sortCampByTotalSlots;}
    public SortCampByCampComSlots getSortCampByCampComSlots(){return sortCampByCampComSlots;}
    public SortCampByDescription getSortCampByDescription(){return sortCampByDescription;}
    public SortCampByStaffIC getSortCampByStaffIC(){return sortCampByStaffIC;}
    public SortCampByOpenTo getSortCampByOpenTo(){return sortCampByOpenTo;}
    public SortCampByAttendeeSlots getSortCampByAttendeeSlots(){return sortCampByAttendeeSlots;}
    public SortCampByAvailableAttendeeSlots getSortCampByAvailableAttendeeSlots(){return sortCampByAvailableAttendeeSlots;}
    public SortCampByAvailableCampCommiteeSlots getSortCampByAvailableCampCommiteeSlots(){return sortCampByAvailableCampCommiteeSlots;}
    

    public CampDataBase getCampDataBase()
    {
        return campDataBase;
    }
}
