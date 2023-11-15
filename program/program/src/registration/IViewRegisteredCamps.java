package registration;

import camp;
import enquiries;
import misc;
import suggestions;
import user;

public interface IViewRegisteredCamps 
{
    public void viewRegisteredCamps(Student student,ISortCamps iSortCamps,IFilterCamps iFilterCamps,String filterString);
}
