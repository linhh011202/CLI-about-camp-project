package merge;

public interface IGeneratePerformanceReport 
{
    public void generatePerformanceReport(UserDataBase userDataBase,User user,ISortCamps iSortCamps,IFilterCamps iFilterCamps,String filterString);
}
