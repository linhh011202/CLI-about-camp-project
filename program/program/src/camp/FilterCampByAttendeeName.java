package merge;

import java.util.ArrayList;

public class FilterCampByAttendeeName implements IFilterCamps
{
    private FilterManager filterManager;
    private ICheckRegistration attendeeRegistrationChecker;

    public FilterCampByAttendeeName(FilterManager filterManager,ICheckRegistration attendeeRegistrationChecker)
    {
        this.filterManager=filterManager;
        this.attendeeRegistrationChecker=attendeeRegistrationChecker;
    }

    public void filterCamps(String filterString)
    {
        ArrayList<Camp> allCamps=filterManager.getCampDataBase().getAllCamps();
        for(int i=0;i<allCamps.size();++i)
        {
            //Set filtered marker on camps according to whether there is said student in camp or not.
            if(attendeeRegistrationChecker.checkRegistration(filterString, allCamps.get(i).getCampName()))
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
