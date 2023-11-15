package merge;

import java.util.ArrayList;

public class FilterCampByOpenTo implements IFilterCamps
{
    private FilterManager filterManager;

    public FilterCampByOpenTo(FilterManager filterManager)
    {
        this.filterManager=filterManager;
    }

    public void filterCamps(String filterString)
    {
        ArrayList<Camp> allCamps=filterManager.getCampDataBase().getAllCamps();
        for(int i=0;i<allCamps.size();++i)
        {
            //Set filtered marker on camps according to whether they match the Faculty or not.
            if(allCamps.get(i).getOpenTo().name().equals(filterString.toUpperCase()))
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
