package camp;

public interface IGenerateStudentReport 
{
    public void generateStudentReport(User user,ISortCamps iSortCamps,IFilterCamps iFilterCamps,String filterString);
}
