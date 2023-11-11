package merge;

import java.util.ArrayList;

public class FilterCampByCampComSlots implements IFilterCamps
{
    private FilterManager filterManager;

    public FilterCampByCampComSlots(FilterManager filterManager)
    {
        this.filterManager=filterManager;
    }

    public void filterCamps(String filterString)
    {
        ArrayList<Camp> allCamps=filterManager.getCampDataBase().getAllCamps();
        for(int i=0;i<allCamps.size();++i)
        {
            //Set filtered marker on camps according to whether they match or not.
            if(allCamps.get(i).getCampComSlots()==Integer.valueOf(filterString))
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
