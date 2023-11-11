package camp;

import java.util.ArrayList;

public class FilterCampByAttendeeSlots implements IFilterCamps
{
    private FilterManager filterManager;

    public FilterCampByAttendeeSlots(FilterManager filterManager)
    {
        this.filterManager=filterManager;
    }

    public void filterCamps(String filterString)
    {
        ArrayList<Camp> allCamps=filterManager.getCampDataBase().getAllCamps();
        for(int i=0;i<allCamps.size();++i)
        {
            //Set filtered marker on camps according to whether they match or not.
            if(allCamps.get(i).getAttendeeSlots()==Integer.valueOf(filterString))
            {
                allCamps.get(i).setIsFilteredOut(false);
            }
            else
            {
                allCamps.get(i).setIsFilteredOut(true);
            }
        }
    }

}