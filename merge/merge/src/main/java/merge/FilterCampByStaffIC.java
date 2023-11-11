package merge;

import java.util.ArrayList;

public class FilterCampByStaffIC implements IFilterCamps
{
    private FilterManager filterManager;

    public FilterCampByStaffIC(FilterManager filterManager)
    {
        this.filterManager=filterManager;
    }

    public void filterCamps(String filterString)
    {
        ArrayList<Camp> allCamps=filterManager.getCampDataBase().getAllCamps();
        for(int i=0;i<allCamps.size();++i)
        {
            //Set filtered marker on camps according to whether they match the description or not.
            if(allCamps.get(i).getStaffInCharge().equals(filterString))
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