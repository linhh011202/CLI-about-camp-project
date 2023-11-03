package camp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FilterCampByStaffIC implements IFilterCamps
{
    private FilterManager filterManager;

    FilterCampByStaffIC(FilterManager filterManager)
    {
        this.filterManager=filterManager;
    }

    public void filterCamps()
    {
        //get all camps in database and sort.
        ArrayList<Camp> allCamps=filterManager.getCampDataBase().getAllCamps();

        Comparator<Camp> byCampName = Comparator.comparing(Camp::getStaffInCharge);
        // Sort the list using the custom Comparator
        Collections.sort(allCamps, byCampName);
    }
}