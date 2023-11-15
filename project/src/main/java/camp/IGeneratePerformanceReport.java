package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public interface IGeneratePerformanceReport {
    public void generatePerformanceReport(UserDataBase userDataBase, User user, ISortCamps iSortCamps,
            IFilterCamps iFilterCamps, String filterString);
}
