package camp;

public class FilterManager 
{
    private CampDataBase campDataBase;

    private FilterCampByCampName filterCampByCampName;
    private FilterCampByNothing filterCampByNothing;
    private FilterCampByStartDate filterCampByStartDate;
    private FilterCampByEndDate filterCampByEndDate;
    private FilterCampByRegClosingDate filterCampByRegClosingDate;
    private FilterCampByVisibility filterCampByVisibility;
    private FilterCampByLocation filterCampByLocation;
    private FilterCampByTotalSlots filterCampByTotalSlots;
    private FilterCampByAttendeeSlots filterCampByAttendeeSlots;
    private FilterCampByCampComSlots filterCampByCampComSlots;
    private FilterCampByAvailableCampComSlots filterCampByAvailableCampComSlots;
    private FilterCampByAvailableAttendeeSlots filterCampByAvailableAttendeeSlots;
    private FilterCampByStaffIC filterCampByStaffIC;
    private FilterCampByOpenTo filterCampByOpenTo;

    public FilterManager(CampDataBase campDataBase)
    {
        this.campDataBase=campDataBase;
        this.filterCampByCampName=new FilterCampByCampName(this);
        this.filterCampByNothing=new FilterCampByNothing(this);
        this.filterCampByStartDate=new FilterCampByStartDate(this);
        this.filterCampByEndDate=new FilterCampByEndDate(this);
        this.filterCampByRegClosingDate=new FilterCampByRegClosingDate(this);
        this.filterCampByVisibility=new FilterCampByVisibility(this);
        this.filterCampByLocation=new FilterCampByLocation(this);
        this.filterCampByTotalSlots=new FilterCampByTotalSlots(this);
        this.filterCampByAttendeeSlots=new FilterCampByAttendeeSlots(this);
        this.filterCampByCampComSlots=new FilterCampByCampComSlots(this);
        this.filterCampByAvailableCampComSlots=new FilterCampByAvailableCampComSlots(this);
        this.filterCampByAvailableAttendeeSlots=new FilterCampByAvailableAttendeeSlots(this);
        this.filterCampByStaffIC=new FilterCampByStaffIC(this);
        this.filterCampByOpenTo=new FilterCampByOpenTo(this);
    }

    public CampDataBase getCampDataBase()
    {
        return campDataBase;
    }

    public FilterCampByCampName getFilterCampByCampName()
    {
        return filterCampByCampName;
    }

    public FilterCampByNothing getFilterCampByNothing()
    {
        return filterCampByNothing;
    }

    public FilterCampByStartDate getFilterCampByStartDate()
    {
        return filterCampByStartDate;
    }

    public FilterCampByEndDate getFilterCampByEndDate()
    {
        return filterCampByEndDate;
    }

    public FilterCampByRegClosingDate getFilterCampByRegClosingDate()
    {
        return filterCampByRegClosingDate;
    }

    public FilterCampByVisibility getFilterCampByVisibility()
    {
        return filterCampByVisibility;
    }

    public FilterCampByLocation getFilterCampByLocation()
    {
        return filterCampByLocation;
    }

    public FilterCampByTotalSlots getFilterCampByTotalSlots()
    {
        return filterCampByTotalSlots;
    }

    public FilterCampByAttendeeSlots getFilterCampByAttendeeSlots()
    {
        return filterCampByAttendeeSlots;
    }

    public FilterCampByCampComSlots getFilterCampByCampComSlots()
    {
        return filterCampByCampComSlots;
    }

    public FilterCampByAvailableCampComSlots getFilterCampByAvailableCampComSlots()
    {
        return filterCampByAvailableCampComSlots;
    }

    public FilterCampByAvailableAttendeeSlots getFilterCampByAvailableAttendeeSlots()
    {
        return filterCampByAvailableAttendeeSlots;
    }

    public FilterCampByStaffIC getFilterCampByStaffIC()
    {
        return filterCampByStaffIC;
    }

    public FilterCampByOpenTo getFilterCampByOpenTo()
    {
        return filterCampByOpenTo;
    }

}
