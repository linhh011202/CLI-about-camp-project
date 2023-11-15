package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public interface IViewAllCamps {
    public void viewAllCamps(User user, ISortCamps iSortCamps, IFilterCamps iFilterCamps, String filterString);
}