package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public interface IGenerateStudentReport {
    public void generateStudentReport(User user, ISortCamps iSortCamps, IFilterCamps iFilterCamps, String filterString);
}
